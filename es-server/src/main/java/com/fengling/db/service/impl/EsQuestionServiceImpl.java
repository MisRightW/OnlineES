package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestion;
import com.fengling.db.mapper.EsQuestionMapper;
import com.fengling.db.service.IEsQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 问题题目 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsQuestionServiceImpl extends ServiceImpl<EsQuestionMapper, EsQuestion> implements IEsQuestionService {


    @Autowired
    private EsQuestionMapper esQuestionMapper;

    @Override
    public Page<EsQuestion> selectPage(EsQuestion param, Page page) {
        QueryWrapper<EsQuestion> entityWrapper = new QueryWrapper<EsQuestion>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsQuestion> selectList(EsQuestion param) {
        QueryWrapper<EsQuestion> entityWrapper = new QueryWrapper<EsQuestion>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsQuestion> getEntityWrapper(QueryWrapper<EsQuestion> entityWrapper,EsQuestion esQuestion){
        QueryWrapper<EsQuestion> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esQuestion.getDeleted())){
            result = entityWrapper.like("DELETED",esQuestion.getDeleted());
        }
        if (StringUtils.isNotBlank(esQuestion.getContent())){
            result = entityWrapper.like("CONTENT",esQuestion.getContent());
        }
        if (StringUtils.isNotBlank(esQuestion.getImage())){
            result = entityWrapper.like("IMAGE",esQuestion.getImage());
        }
        if (StringUtils.isNotBlank(esQuestion.getVideo())){
            result = entityWrapper.like("VIDEO",esQuestion.getVideo());
        }
        if (StringUtils.isNotBlank(esQuestion.getRemark())){
            result = entityWrapper.like("REMARK",esQuestion.getRemark());
        }
        if (StringUtils.isNotBlank(esQuestion.getAnalysis())){
            result = entityWrapper.like("ANALYSIS",esQuestion.getAnalysis());
        }
        return result;
    }
}