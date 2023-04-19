package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsPaperQuestionAnswer;
import com.fengling.db.mapper.EsPaperQuestionAnswerMapper;
import com.fengling.db.service.IEsPaperQuestionAnswerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 试卷考题备选答案 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsPaperQuestionAnswerServiceImpl extends ServiceImpl<EsPaperQuestionAnswerMapper, EsPaperQuestionAnswer> implements IEsPaperQuestionAnswerService {


    @Autowired
    private EsPaperQuestionAnswerMapper esPaperQuestionAnswerMapper;

    @Override
    public Page<EsPaperQuestionAnswer> selectPage(EsPaperQuestionAnswer param, Page page) {
        QueryWrapper<EsPaperQuestionAnswer> entityWrapper = new QueryWrapper<EsPaperQuestionAnswer>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsPaperQuestionAnswer> selectList(EsPaperQuestionAnswer param) {
        QueryWrapper<EsPaperQuestionAnswer> entityWrapper = new QueryWrapper<EsPaperQuestionAnswer>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsPaperQuestionAnswer> getEntityWrapper(QueryWrapper<EsPaperQuestionAnswer> entityWrapper,EsPaperQuestionAnswer esPaperQuestionAnswer){
        QueryWrapper<EsPaperQuestionAnswer> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esPaperQuestionAnswer.getDeleted())){
            result = entityWrapper.like("DELETED",esPaperQuestionAnswer.getDeleted());
        }
        if (StringUtils.isNotBlank(esPaperQuestionAnswer.getType())){
            result = entityWrapper.like("TYPE",esPaperQuestionAnswer.getType());
        }
        return result;
    }
}