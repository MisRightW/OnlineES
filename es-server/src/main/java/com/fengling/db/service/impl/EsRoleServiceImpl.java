package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsRole;
import com.fengling.db.mapper.EsRoleMapper;
import com.fengling.db.service.IEsRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsRoleServiceImpl extends ServiceImpl<EsRoleMapper, EsRole> implements IEsRoleService {


    @Autowired
    private EsRoleMapper esRoleMapper;

    @Override
    public Page<EsRole> selectPage(EsRole param, Page page) {
        QueryWrapper<EsRole> entityWrapper = new QueryWrapper<EsRole>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsRole> selectList(EsRole param) {
        QueryWrapper<EsRole> entityWrapper = new QueryWrapper<EsRole>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsRole> getEntityWrapper(QueryWrapper<EsRole> entityWrapper,EsRole esRole){
        QueryWrapper<EsRole> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esRole.getDeleted())){
            result = entityWrapper.like("DELETED",esRole.getDeleted());
        }
        if (StringUtils.isNotBlank(esRole.getRoleName())){
            result = entityWrapper.like("ROLE_NAME",esRole.getRoleName());
        }
        return result;
    }
}