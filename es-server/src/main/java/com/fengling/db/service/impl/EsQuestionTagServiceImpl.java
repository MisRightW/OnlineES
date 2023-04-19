package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestionTag;
import com.fengling.db.mapper.EsQuestionTagMapper;
import com.fengling.db.service.IEsQuestionTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsQuestionTagServiceImpl extends ServiceImpl<EsQuestionTagMapper, EsQuestionTag> implements IEsQuestionTagService {


    @Autowired
    private EsQuestionTagMapper esQuestionTagMapper;

    @Override
    public Page<EsQuestionTag> selectPage(EsQuestionTag param, Page page) {
        QueryWrapper<EsQuestionTag> entityWrapper = new QueryWrapper<EsQuestionTag>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsQuestionTag> selectList(EsQuestionTag param) {
        QueryWrapper<EsQuestionTag> entityWrapper = new QueryWrapper<EsQuestionTag>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsQuestionTag> getEntityWrapper(QueryWrapper<EsQuestionTag> entityWrapper,EsQuestionTag esQuestionTag){
        QueryWrapper<EsQuestionTag> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esQuestionTag.getDeleted())){
            result = entityWrapper.like("DELETED",esQuestionTag.getDeleted());
        }
        if (StringUtils.isNotBlank(esQuestionTag.getTagName())){
            result = entityWrapper.like("TAG_NAME",esQuestionTag.getTagName());
        }
        return result;
    }
}