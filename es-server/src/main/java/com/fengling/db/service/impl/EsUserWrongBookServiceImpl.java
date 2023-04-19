package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsUserWrongBook;
import com.fengling.db.mapper.EsUserWrongBookMapper;
import com.fengling.db.service.IEsUserWrongBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 错题本 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsUserWrongBookServiceImpl extends ServiceImpl<EsUserWrongBookMapper, EsUserWrongBook> implements IEsUserWrongBookService {


    @Autowired
    private EsUserWrongBookMapper esUserWrongBookMapper;

    @Override
    public Page<EsUserWrongBook> selectPage(EsUserWrongBook param, Page page) {
        QueryWrapper<EsUserWrongBook> entityWrapper = new QueryWrapper<EsUserWrongBook>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsUserWrongBook> selectList(EsUserWrongBook param) {
        QueryWrapper<EsUserWrongBook> entityWrapper = new QueryWrapper<EsUserWrongBook>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsUserWrongBook> getEntityWrapper(QueryWrapper<EsUserWrongBook> entityWrapper,EsUserWrongBook esUserWrongBook){
        QueryWrapper<EsUserWrongBook> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esUserWrongBook.getDeleted())){
            result = entityWrapper.like("DELETED",esUserWrongBook.getDeleted());
        }
        if (StringUtils.isNotBlank(esUserWrongBook.getQuestionId())){
            result = entityWrapper.like("QUESTION_ID",esUserWrongBook.getQuestionId());
        }
        if (StringUtils.isNotBlank(esUserWrongBook.getTitle())){
            result = entityWrapper.like("TITLE",esUserWrongBook.getTitle());
        }
        return result;
    }
}