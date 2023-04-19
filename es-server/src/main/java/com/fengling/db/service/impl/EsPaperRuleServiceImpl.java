package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsPaperRule;
import com.fengling.db.mapper.EsPaperRuleMapper;
import com.fengling.db.service.IEsPaperRuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 试卷规则 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsPaperRuleServiceImpl extends ServiceImpl<EsPaperRuleMapper, EsPaperRule> implements IEsPaperRuleService {


    @Autowired
    private EsPaperRuleMapper esPaperRuleMapper;

    @Override
    public Page<EsPaperRule> selectPage(EsPaperRule param, Page page) {
        QueryWrapper<EsPaperRule> entityWrapper = new QueryWrapper<EsPaperRule>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsPaperRule> selectList(EsPaperRule param) {
        QueryWrapper<EsPaperRule> entityWrapper = new QueryWrapper<EsPaperRule>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsPaperRule> getEntityWrapper(QueryWrapper<EsPaperRule> entityWrapper,EsPaperRule esPaperRule){
        QueryWrapper<EsPaperRule> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esPaperRule.getDeleted())){
            result = entityWrapper.like("DELETED",esPaperRule.getDeleted());
        }
        if (StringUtils.isNotBlank(esPaperRule.getTitle())){
            result = entityWrapper.like("TITLE",esPaperRule.getTitle());
        }
        if (StringUtils.isNotBlank(esPaperRule.getRemark())){
            result = entityWrapper.like("REMARK",esPaperRule.getRemark());
        }
        if (StringUtils.isNotBlank(esPaperRule.getCode())){
            result = entityWrapper.like("CODE",esPaperRule.getCode());
        }
        return result;
    }
}