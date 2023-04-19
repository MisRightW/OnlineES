package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsUser;
import com.fengling.db.mapper.EsUserMapper;
import com.fengling.db.service.IEsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 管理用户 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsUserServiceImpl extends ServiceImpl<EsUserMapper, EsUser> implements IEsUserService {


    @Autowired
    private EsUserMapper esUserMapper;

    @Override
    public Page<EsUser> selectPage(EsUser param, Page page) {
        QueryWrapper<EsUser> entityWrapper = new QueryWrapper<EsUser>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsUser> selectList(EsUser param) {
        QueryWrapper<EsUser> entityWrapper = new QueryWrapper<EsUser>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsUser> getEntityWrapper(QueryWrapper<EsUser> entityWrapper,EsUser esUser){
        QueryWrapper<EsUser> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esUser.getDeleted())){
            result = entityWrapper.like("DELETED",esUser.getDeleted());
        }
        if (StringUtils.isNotBlank(esUser.getUserName())){
            result = entityWrapper.like("USER_NAME",esUser.getUserName());
        }
        if (StringUtils.isNotBlank(esUser.getAvatar())){
            result = entityWrapper.like("AVATAR",esUser.getAvatar());
        }
        if (StringUtils.isNotBlank(esUser.getRealName())){
            result = entityWrapper.like("REAL_NAME",esUser.getRealName());
        }
        if (StringUtils.isNotBlank(esUser.getPassword())){
            result = entityWrapper.like("PASSWORD",esUser.getPassword());
        }
        if (StringUtils.isNotBlank(esUser.getSalt())){
            result = entityWrapper.like("SALT",esUser.getSalt());
        }
        if (StringUtils.isNotBlank(esUser.getRoleIds())){
            result = entityWrapper.like("ROLE_IDS",esUser.getRoleIds());
        }
        return result;
    }
}