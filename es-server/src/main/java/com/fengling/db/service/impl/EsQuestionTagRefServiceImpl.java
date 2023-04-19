package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestionTagRef;
import com.fengling.db.mapper.EsQuestionTagRefMapper;
import com.fengling.db.service.IEsQuestionTagRefService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 题目标签 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsQuestionTagRefServiceImpl extends ServiceImpl<EsQuestionTagRefMapper, EsQuestionTagRef> implements IEsQuestionTagRefService {


    @Autowired
    private EsQuestionTagRefMapper esQuestionTagRefMapper;

    @Override
    public Page<EsQuestionTagRef> selectPage(EsQuestionTagRef param, Page page) {
        QueryWrapper<EsQuestionTagRef> entityWrapper = new QueryWrapper<EsQuestionTagRef>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsQuestionTagRef> selectList(EsQuestionTagRef param) {
        QueryWrapper<EsQuestionTagRef> entityWrapper = new QueryWrapper<EsQuestionTagRef>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsQuestionTagRef> getEntityWrapper(QueryWrapper<EsQuestionTagRef> entityWrapper,EsQuestionTagRef esQuestionTagRef){
        QueryWrapper<EsQuestionTagRef> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esQuestionTagRef.getDeleted())){
            result = entityWrapper.like("DELETED",esQuestionTagRef.getDeleted());
        }
        return result;
    }
}