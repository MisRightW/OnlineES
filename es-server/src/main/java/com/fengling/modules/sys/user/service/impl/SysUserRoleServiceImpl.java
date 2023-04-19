package com.fengling.modules.sys.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.core.api.dto.PagingReqDTO;
import com.fengling.modules.sys.user.dto.SysUserRoleDTO;
import com.fengling.modules.sys.user.entity.SysUserRole;
import com.fengling.modules.sys.user.mapper.SysUserRoleMapper;
import com.fengling.modules.sys.user.service.SysUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
* 语言设置 服务实现类
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Override
    public IPage<SysUserRoleDTO> paging(PagingReqDTO<SysUserRoleDTO> reqDTO) {

        //创建分页对象
        IPage<SysUserRole> query = new Page<>(reqDTO.getCurrent(), reqDTO.getSize());

        //查询条件
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();

        //获得数据
        IPage<SysUserRole> page = this.page(query, wrapper);
        //转换结果
        IPage<SysUserRoleDTO> pageData = JSON.parseObject(JSON.toJSONString(page), new TypeReference<Page<SysUserRoleDTO>>(){});
        return pageData;
     }

    @Override
    public List<String> listRoles(String userId) {

        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserRole::getUserId, userId);

        List<SysUserRole> list = this.list(wrapper);
        List<String> roles = new ArrayList<>();
        if(!CollectionUtils.isEmpty(list)){
            for(SysUserRole item: list){
                roles.add(item.getRoleId());
            }
        }

        return roles;
    }

    @Override
    public String saveRoles(String userId, List<String> ids) {

        // 删除全部角色
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserRole::getUserId, userId);
        this.remove(wrapper);


        if(!CollectionUtils.isEmpty(ids)){

            List<SysUserRole> list = new ArrayList<>();
            String roleIds = null;

            for(String item: ids){
                SysUserRole role = new SysUserRole();
                role.setRoleId(item);
                role.setUserId(userId);
                list.add(role);
                if(StringUtils.isEmpty(roleIds)){
                    roleIds = item;
                }else{
                    roleIds+=","+item;
                }
            }

            this.saveBatch(list);
            return roleIds;
        }

        return "";
    }

    @Override
    public boolean isStudent(String userId) {

        // 学生角色
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserRole::getUserId, userId)
                .eq(SysUserRole::getRoleId, "student");

        return this.count(wrapper) > 0;
    }

    @Override
    public boolean isTeacher(String userId) {
        // 学生角色
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserRole::getUserId, userId)
                .eq(SysUserRole::getRoleId, "teacher");

        return this.count(wrapper) > 0;
    }

    @Override
    public boolean isAdmin(String userId) {
        // 学生角色
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserRole::getUserId, userId)
                .eq(SysUserRole::getRoleId, "sa");

        return this.count(wrapper) > 0;
    }

    @Override
    public boolean save(SysUserRole entity) {
        return super.save(entity);
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public List<SysUserRole> list() {
        return super.list();
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
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
        return super.pageMaps(page);
    }

    @Override
    public QueryChainWrapper<SysUserRole> query() {
        return super.query();
    }

    @Override
    public LambdaQueryChainWrapper<SysUserRole> lambdaQuery() {
        return super.lambdaQuery();
    }

    @Override
    public UpdateChainWrapper<SysUserRole> update() {
        return super.update();
    }

    @Override
    public LambdaUpdateChainWrapper<SysUserRole> lambdaUpdate() {
        return super.lambdaUpdate();
    }

    @Override
    public boolean saveOrUpdate(SysUserRole entity, Wrapper<SysUserRole> updateWrapper) {
        return super.saveOrUpdate(entity, updateWrapper);
    }


    @Override
    public boolean update(SysUserRole entity, Wrapper<SysUserRole> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    public boolean updateById(SysUserRole entity) {
        return super.updateById(entity);
    }
}
