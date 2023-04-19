package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsUserWare;
import com.fengling.db.mapper.EsUserWareMapper;
import com.fengling.db.service.IEsUserWareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 课件阅读记录 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsUserWareServiceImpl extends ServiceImpl<EsUserWareMapper, EsUserWare> implements IEsUserWareService {


    @Autowired
    private EsUserWareMapper esUserWareMapper;

    @Override
    public Page<EsUserWare> selectPage(EsUserWare param, Page page) {
        QueryWrapper<EsUserWare> entityWrapper = new QueryWrapper<EsUserWare>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsUserWare> selectList(EsUserWare param) {
        QueryWrapper<EsUserWare> entityWrapper = new QueryWrapper<EsUserWare>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsUserWare> getEntityWrapper(QueryWrapper<EsUserWare> entityWrapper,EsUserWare esUserWare){
        QueryWrapper<EsUserWare> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esUserWare.getDeleted())){
            result = entityWrapper.like("DELETED",esUserWare.getDeleted());
        }
        return result;
    }
}