package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsUserRole;
import com.fengling.db.mapper.EsUserRoleMapper;
import com.fengling.db.service.IEsUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsUserRoleServiceImpl extends ServiceImpl<EsUserRoleMapper, EsUserRole> implements IEsUserRoleService {


    @Autowired
    private EsUserRoleMapper esUserRoleMapper;

    @Override
    public Page<EsUserRole> selectPage(EsUserRole param, Page page) {
        QueryWrapper<EsUserRole> entityWrapper = new QueryWrapper<EsUserRole>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsUserRole> selectList(EsUserRole param) {
        QueryWrapper<EsUserRole> entityWrapper = new QueryWrapper<EsUserRole>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsUserRole> getEntityWrapper(QueryWrapper<EsUserRole> entityWrapper,EsUserRole esUserRole){
        QueryWrapper<EsUserRole> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esUserRole.getDeleted())){
            result = entityWrapper.like("DELETED",esUserRole.getDeleted());
        }
        return result;
    }
}