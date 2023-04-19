package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsExamination;
import com.fengling.db.mapper.EsExaminationMapper;
import com.fengling.db.service.IEsExaminationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsExaminationServiceImpl extends ServiceImpl<EsExaminationMapper, EsExamination> implements IEsExaminationService {


    @Autowired
    private EsExaminationMapper esExaminationMapper;

    @Override
    public Page<EsExamination> selectPage(EsExamination param, Page page) {
        QueryWrapper<EsExamination> entityWrapper = new QueryWrapper<EsExamination>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsExamination> selectList(EsExamination param) {
        QueryWrapper<EsExamination> entityWrapper = new QueryWrapper<EsExamination>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsExamination> getEntityWrapper(QueryWrapper<EsExamination> entityWrapper,EsExamination esExamination){
        QueryWrapper<EsExamination> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esExamination.getDeleted())){
            result = entityWrapper.like("DELETED",esExamination.getDeleted());
        }
        if (StringUtils.isNotBlank(esExamination.getTitle())){
            result = entityWrapper.like("TITLE",esExamination.getTitle());
        }
        if (StringUtils.isNotBlank(esExamination.getContent())){
            result = entityWrapper.like("CONTENT",esExamination.getContent());
        }
        if (StringUtils.isNotBlank(esExamination.getPassword())){
            result = entityWrapper.like("PASSWORD",esExamination.getPassword());
        }
        return result;
    }
}