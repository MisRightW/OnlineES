package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestionRepo;
import com.fengling.db.mapper.EsQuestionRepoMapper;
import com.fengling.db.service.IEsQuestionRepoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 题库 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsQuestionRepoServiceImpl extends ServiceImpl<EsQuestionRepoMapper, EsQuestionRepo> implements IEsQuestionRepoService {


    @Autowired
    private EsQuestionRepoMapper esQuestionRepoMapper;

    @Override
    public Page<EsQuestionRepo> selectPage(EsQuestionRepo param, Page page) {
        QueryWrapper<EsQuestionRepo> entityWrapper = new QueryWrapper<EsQuestionRepo>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsQuestionRepo> selectList(EsQuestionRepo param) {
        QueryWrapper<EsQuestionRepo> entityWrapper = new QueryWrapper<EsQuestionRepo>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsQuestionRepo> getEntityWrapper(QueryWrapper<EsQuestionRepo> entityWrapper,EsQuestionRepo esQuestionRepo){
        QueryWrapper<EsQuestionRepo> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esQuestionRepo.getDeleted())){
            result = entityWrapper.like("DELETED",esQuestionRepo.getDeleted());
        }
        if (StringUtils.isNotBlank(esQuestionRepo.getCode())){
            result = entityWrapper.like("CODE",esQuestionRepo.getCode());
        }
        if (StringUtils.isNotBlank(esQuestionRepo.getTitle())){
            result = entityWrapper.like("TITLE",esQuestionRepo.getTitle());
        }
        if (StringUtils.isNotBlank(esQuestionRepo.getRemark())){
            result = entityWrapper.like("REMARK",esQuestionRepo.getRemark());
        }
        return result;
    }
}