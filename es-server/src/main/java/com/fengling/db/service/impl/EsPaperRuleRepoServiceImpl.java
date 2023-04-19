package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsPaperRuleRepo;
import com.fengling.db.mapper.EsPaperRuleRepoMapper;
import com.fengling.db.service.IEsPaperRuleRepoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 规则题库 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsPaperRuleRepoServiceImpl extends ServiceImpl<EsPaperRuleRepoMapper, EsPaperRuleRepo> implements IEsPaperRuleRepoService {


    @Autowired
    private EsPaperRuleRepoMapper esPaperRuleRepoMapper;

    @Override
    public Page<EsPaperRuleRepo> selectPage(EsPaperRuleRepo param, Page page) {
        QueryWrapper<EsPaperRuleRepo> entityWrapper = new QueryWrapper<EsPaperRuleRepo>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsPaperRuleRepo> selectList(EsPaperRuleRepo param) {
        QueryWrapper<EsPaperRuleRepo> entityWrapper = new QueryWrapper<EsPaperRuleRepo>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsPaperRuleRepo> getEntityWrapper(QueryWrapper<EsPaperRuleRepo> entityWrapper,EsPaperRuleRepo esPaperRuleRepo){
        QueryWrapper<EsPaperRuleRepo> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esPaperRuleRepo.getDeleted())){
            result = entityWrapper.like("DELETED",esPaperRuleRepo.getDeleted());
        }
        return result;
    }
}