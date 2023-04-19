package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestionRepoRef;
import com.fengling.db.mapper.EsQuestionRepoRefMapper;
import com.fengling.db.service.IEsQuestionRepoRefService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 试题题库 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsQuestionRepoRefServiceImpl extends ServiceImpl<EsQuestionRepoRefMapper, EsQuestionRepoRef> implements IEsQuestionRepoRefService {


    @Autowired
    private EsQuestionRepoRefMapper esQuestionRepoRefMapper;

    @Override
    public Page<EsQuestionRepoRef> selectPage(EsQuestionRepoRef param, Page page) {
        QueryWrapper<EsQuestionRepoRef> entityWrapper = new QueryWrapper<EsQuestionRepoRef>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsQuestionRepoRef> selectList(EsQuestionRepoRef param) {
        QueryWrapper<EsQuestionRepoRef> entityWrapper = new QueryWrapper<EsQuestionRepoRef>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsQuestionRepoRef> getEntityWrapper(QueryWrapper<EsQuestionRepoRef> entityWrapper,EsQuestionRepoRef esQuestionRepoRef){
        QueryWrapper<EsQuestionRepoRef> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esQuestionRepoRef.getDeleted())){
            result = entityWrapper.like("DELETED",esQuestionRepoRef.getDeleted());
        }
        return result;
    }
}