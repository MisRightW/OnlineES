package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsPaperQuestion;
import com.fengling.db.mapper.EsPaperQuestionMapper;
import com.fengling.db.service.IEsPaperQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 试卷考题 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsPaperQuestionServiceImpl extends ServiceImpl<EsPaperQuestionMapper, EsPaperQuestion> implements IEsPaperQuestionService {


    @Autowired
    private EsPaperQuestionMapper esPaperQuestionMapper;

    @Override
    public Page<EsPaperQuestion> selectPage(EsPaperQuestion param, Page page) {
        QueryWrapper<EsPaperQuestion> entityWrapper = new QueryWrapper<EsPaperQuestion>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsPaperQuestion> selectList(EsPaperQuestion param) {
        QueryWrapper<EsPaperQuestion> entityWrapper = new QueryWrapper<EsPaperQuestion>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsPaperQuestion> getEntityWrapper(QueryWrapper<EsPaperQuestion> entityWrapper,EsPaperQuestion esPaperQuestion){
        QueryWrapper<EsPaperQuestion> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esPaperQuestion.getDeleted())){
            result = entityWrapper.like("DELETED",esPaperQuestion.getDeleted());
        }
        if (StringUtils.isNotBlank(esPaperQuestion.getAnswer())){
            result = entityWrapper.like("ANSWER",esPaperQuestion.getAnswer());
        }
        return result;
    }
}