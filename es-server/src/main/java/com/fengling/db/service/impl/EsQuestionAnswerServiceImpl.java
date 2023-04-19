package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestionAnswer;
import com.fengling.db.mapper.EsQuestionAnswerMapper;
import com.fengling.db.service.IEsQuestionAnswerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 候选答案 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsQuestionAnswerServiceImpl extends ServiceImpl<EsQuestionAnswerMapper, EsQuestionAnswer> implements IEsQuestionAnswerService {


    @Autowired
    private EsQuestionAnswerMapper esQuestionAnswerMapper;

    @Override
    public Page<EsQuestionAnswer> selectPage(EsQuestionAnswer param, Page page) {
        QueryWrapper<EsQuestionAnswer> entityWrapper = new QueryWrapper<EsQuestionAnswer>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsQuestionAnswer> selectList(EsQuestionAnswer param) {
        QueryWrapper<EsQuestionAnswer> entityWrapper = new QueryWrapper<EsQuestionAnswer>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsQuestionAnswer> getEntityWrapper(QueryWrapper<EsQuestionAnswer> entityWrapper,EsQuestionAnswer esQuestionAnswer){
        QueryWrapper<EsQuestionAnswer> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esQuestionAnswer.getDeleted())){
            result = entityWrapper.like("DELETED",esQuestionAnswer.getDeleted());
        }
        if (StringUtils.isNotBlank(esQuestionAnswer.getContent())){
            result = entityWrapper.like("CONTENT",esQuestionAnswer.getContent());
        }
        if (StringUtils.isNotBlank(esQuestionAnswer.getImage())){
            result = entityWrapper.like("IMAGE",esQuestionAnswer.getImage());
        }
        if (StringUtils.isNotBlank(esQuestionAnswer.getAnalysis())){
            result = entityWrapper.like("ANALYSIS",esQuestionAnswer.getAnalysis());
        }
        return result;
    }
}