package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsSystemConfig;
import com.fengling.db.mapper.EsSystemConfigMapper;
import com.fengling.db.service.IEsSystemConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 通用配置 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsSystemConfigServiceImpl extends ServiceImpl<EsSystemConfigMapper, EsSystemConfig> implements IEsSystemConfigService {


    @Autowired
    private EsSystemConfigMapper esSystemConfigMapper;

    @Override
    public Page<EsSystemConfig> selectPage(EsSystemConfig param, Page page) {
        QueryWrapper<EsSystemConfig> entityWrapper = new QueryWrapper<EsSystemConfig>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsSystemConfig> selectList(EsSystemConfig param) {
        QueryWrapper<EsSystemConfig> entityWrapper = new QueryWrapper<EsSystemConfig>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsSystemConfig> getEntityWrapper(QueryWrapper<EsSystemConfig> entityWrapper,EsSystemConfig esSystemConfig){
        QueryWrapper<EsSystemConfig> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esSystemConfig.getDeleted())){
            result = entityWrapper.like("DELETED",esSystemConfig.getDeleted());
        }
        return result;
    }
}