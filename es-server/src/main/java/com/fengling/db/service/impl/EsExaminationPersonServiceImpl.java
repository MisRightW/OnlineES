package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsExaminationPerson;
import com.fengling.db.mapper.EsExaminationPersonMapper;
import com.fengling.db.service.IEsExaminationPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsExaminationPersonServiceImpl extends ServiceImpl<EsExaminationPersonMapper, EsExaminationPerson> implements IEsExaminationPersonService {


    @Autowired
    private EsExaminationPersonMapper esExaminationPersonMapper;

    @Override
    public Page<EsExaminationPerson> selectPage(EsExaminationPerson param, Page page) {
        QueryWrapper<EsExaminationPerson> entityWrapper = new QueryWrapper<EsExaminationPerson>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsExaminationPerson> selectList(EsExaminationPerson param) {
        QueryWrapper<EsExaminationPerson> entityWrapper = new QueryWrapper<EsExaminationPerson>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsExaminationPerson> getEntityWrapper(QueryWrapper<EsExaminationPerson> entityWrapper,EsExaminationPerson esExaminationPerson){
        QueryWrapper<EsExaminationPerson> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esExaminationPerson.getDeleted())){
            result = entityWrapper.like("DELETED",esExaminationPerson.getDeleted());
        }
        if (StringUtils.isNotBlank(esExaminationPerson.getUserName())){
            result = entityWrapper.like("USER_NAME",esExaminationPerson.getUserName());
        }
        return result;
    }
}