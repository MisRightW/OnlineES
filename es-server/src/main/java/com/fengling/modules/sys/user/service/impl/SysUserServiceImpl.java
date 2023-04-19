package com.fengling.modules.sys.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.core.api.ApiError;
import com.fengling.core.api.dto.PagingReqDTO;
import com.fengling.core.api.enums.CommonState;
import com.fengling.core.exception.ServiceException;
import com.fengling.core.utils.BeanMapper;
import com.fengling.core.utils.StringUtils;
import com.fengling.core.utils.passwd.PassHandler;
import com.fengling.core.utils.passwd.PassInfo;
import com.fengling.modules.common.redis.service.RedisService;
import com.fengling.modules.sys.user.dto.SysUserDTO;
import com.fengling.modules.sys.user.dto.request.SysUserSaveReqDTO;
import com.fengling.modules.sys.user.dto.response.SysUserLoginDTO;
import com.fengling.modules.sys.user.entity.SysUser;
import com.fengling.modules.sys.user.mapper.SysUserMapper;
import com.fengling.modules.sys.user.service.SysUserRoleService;
import com.fengling.modules.sys.user.service.SysUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
* 语言设置 服务实现类
 * @author fengl
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private RedisService redisService;

    /**
     * 管理员会话前缀
     */
    private static final String ADMIN_SESSION_KEY = "admin:session:";

    /**
     * 管理员账号
     */
    private static final String ADMIN_ACCOUNT = "admin";
    private static final String STUDENT_ACCOUNT = "student";

    @Override
    public IPage<SysUserDTO> paging(PagingReqDTO<SysUserDTO> reqDTO) {

        //创建分页对象
        IPage<SysUser> query = new Page<>(reqDTO.getCurrent(), reqDTO.getSize());

        //查询条件
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();

        //获得数据
        IPage<SysUser> page = this.page(query, wrapper);
        //转换结果
        IPage<SysUserDTO> pageData = JSON.parseObject(JSON.toJSONString(page), new TypeReference<Page<SysUserDTO>>(){});
        return pageData;
     }

    @Override
    public SysUserLoginDTO login(String userName, String password) {

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUser::getUserName, userName);

        SysUser user = this.getOne(wrapper, false);
        if(user == null){
            throw new ServiceException(ApiError.ERROR_90010001);
        }

        // 被禁用
        if(user.getState().equals(CommonState.ABNORMAL)){
            throw new ServiceException(ApiError.ERROR_90010005);
        }

        boolean check = PassHandler.checkPass(password,user.getSalt(), user.getPassword());
        if(!check){
            throw new ServiceException(ApiError.ERROR_90010002);
        }

        SysUserLoginDTO respDTO = new SysUserLoginDTO();
        BeanMapper.copy(user, respDTO);
        respDTO.setToken(RandomStringUtils.randomAlphanumeric(32));

        //查找用户角色
        respDTO.setRoles(sysUserRoleService.listRoles(user.getId()));


        // 设置缓存
        redisService.set(processKey(respDTO.getToken()), JSON.toJSONString(respDTO));

        return respDTO;
    }

    @Override
    public SysUserLoginDTO token(String token) {

        JSONObject json = redisService.getJson(processKey(token));
        if(json == null){
            throw new ServiceException(ApiError.ERROR_10010002);
        }
        return json.toJavaObject(SysUserLoginDTO.class);
    }

    @Override
    public void logout(String token) {

        String [] keys = new String[]{processKey(token)};
        redisService.del(keys);
    }

    @Override
    public void update(SysUserDTO reqDTO) {


       String pass = reqDTO.getPassword();
       if(!StringUtils.isBlank(pass)){
           PassInfo passInfo = PassHandler.buildPassword(pass);
           SysUser user = this.getById(reqDTO.getId());

           if(user.getUserName().equals(ADMIN_ACCOUNT) || user.getUserName().equals(STUDENT_ACCOUNT)){
               // throw new ServiceException(ApiError.ERROR_90010004);
           }

           user.setPassword(passInfo.getPassword());
           user.setSalt(passInfo.getSalt());
           this.updateById(user);
       }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(SysUserSaveReqDTO reqDTO) {

        List<String> roles = reqDTO.getRoles();

        if(CollectionUtils.isEmpty(roles)){
            throw new ServiceException(ApiError.ERROR_90010003);
        }

        // 保存基本信息
        SysUser user = new SysUser();
        BeanMapper.copy(reqDTO, user);

        if(user.getUserName().equals(ADMIN_ACCOUNT) || user.getUserName().equals(STUDENT_ACCOUNT)){
            // throw new ServiceException(ApiError.ERROR_90010004);
        }


        // 添加模式
        if(StringUtils.isBlank(user.getId())){
            user.setId(IdWorker.getIdStr());
        }

        // 修改密码
        if(!StringUtils.isBlank(reqDTO.getPassword())){
            PassInfo pass = PassHandler.buildPassword(reqDTO.getPassword());
            user.setPassword(pass.getPassword());
            user.setSalt(pass.getSalt());
        }

        // 保存角色信息
        String roleIds = sysUserRoleService.saveRoles(user.getId(), roles);
        user.setRoleIds(roleIds);
        this.saveOrUpdate(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysUserLoginDTO reg(SysUserDTO reqDTO) {

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUser::getUserName, reqDTO.getUserName());

        int count = this.count(wrapper);

        if(count > 0){
            throw new ServiceException(1, "用户名已存在，换一个吧！");
        }


        // 保存用户
        SysUser user = new SysUser();
        user.setAvatar("https://face-files.oss-cn-shenzhen.aliyuncs.com/logo.png");
        user.setId(IdWorker.getIdStr());
        user.setUserName(reqDTO.getUserName());
        user.setRealName(reqDTO.getRealName());
        PassInfo passInfo = PassHandler.buildPassword(reqDTO.getPassword());
        user.setPassword(passInfo.getPassword());
        user.setSalt(passInfo.getSalt());

        // 保存角色
        List<String> roles = new ArrayList<>();
        roles.add("student");
        String roleIds = sysUserRoleService.saveRoles(user.getId(), roles);
        user.setRoleIds(roleIds);
        this.save(user);

        SysUserLoginDTO respDTO = new SysUserLoginDTO();
        BeanMapper.copy(user, respDTO);
        respDTO.setToken(RandomStringUtils.randomAlphanumeric(32));
        respDTO.setRoles(roles);

        // 设置缓存
        redisService.set(processKey(respDTO.getToken()), JSON.toJSONString(respDTO));

        return respDTO;
    }

    /**
     * 拼接缓存Key
     * @param token
     * @return
     */
    private String processKey(String token){
        return ADMIN_SESSION_KEY+token;
    }

    @Override
    public boolean save(SysUser entity) {
        return super.save(entity);
    }

    @Override
    public boolean saveBatch(Collection<SysUser> entityList) {
        return super.saveBatch(entityList);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysUser> entityList) {
        return super.saveOrUpdateBatch(entityList);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return super.removeByMap(columnMap);
    }

    @Override
    public boolean remove(Wrapper<SysUser> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return super.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysUser entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean update(Wrapper<SysUser> updateWrapper) {
        return super.update(updateWrapper);
    }

    @Override
    public boolean update(SysUser entity, Wrapper<SysUser> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    public boolean updateBatchById(Collection<SysUser> entityList) {
        return super.updateBatchById(entityList);
    }

    @Override
    public SysUser getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public List<SysUser> listByIds(Collection<? extends Serializable> idList) {
        return super.listByIds(idList);
    }

    @Override
    public List<SysUser> listByMap(Map<String, Object> columnMap) {
        return super.listByMap(columnMap);
    }

    @Override
    public SysUser getOne(Wrapper<SysUser> queryWrapper) {
        return super.getOne(queryWrapper);
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public int count(Wrapper<SysUser> queryWrapper) {
        return super.count(queryWrapper);
    }

    @Override
    public List<SysUser> list(Wrapper<SysUser> queryWrapper) {
        return super.list(queryWrapper);
    }

    @Override
    public List<SysUser> list() {
        return super.list();
    }

    @Override
    public <E extends IPage<SysUser>> E page(E page, Wrapper<SysUser> queryWrapper) {
        return super.page(page, queryWrapper);
    }

    @Override
    public <E extends IPage<SysUser>> E page(E page) {
        return super.page(page);
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<SysUser> queryWrapper) {
        return super.listMaps(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps() {
        return super.listMaps();
    }

    @Override
    public List<Object> listObjs() {
        return super.listObjs();
    }

    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return super.listObjs(mapper);
    }

    @Override
    public List<Object> listObjs(Wrapper<SysUser> queryWrapper) {
        return super.listObjs(queryWrapper);
    }

    @Override
    public <V> List<V> listObjs(Wrapper<SysUser> queryWrapper, Function<? super Object, V> mapper) {
        return super.listObjs(queryWrapper, mapper);
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<SysUser> queryWrapper) {
        return super.pageMaps(page, queryWrapper);
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
        return super.pageMaps(page);
    }

    @Override
    public QueryChainWrapper<SysUser> query() {
        return super.query();
    }

    @Override
    public LambdaQueryChainWrapper<SysUser> lambdaQuery() {
        return super.lambdaQuery();
    }

    @Override
    public UpdateChainWrapper<SysUser> update() {
        return super.update();
    }

    @Override
    public LambdaUpdateChainWrapper<SysUser> lambdaUpdate() {
        return super.lambdaUpdate();
    }

    @Override
    public boolean saveOrUpdate(SysUser entity, Wrapper<SysUser> updateWrapper) {
        return super.saveOrUpdate(entity, updateWrapper);
    }
}
