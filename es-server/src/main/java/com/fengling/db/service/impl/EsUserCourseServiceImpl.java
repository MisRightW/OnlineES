package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsUserCourse;
import com.fengling.db.mapper.EsUserCourseMapper;
import com.fengling.db.service.IEsUserCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 用户课程状态 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsUserCourseServiceImpl extends ServiceImpl<EsUserCourseMapper, EsUserCourse> implements IEsUserCourseService {


    @Autowired
    private EsUserCourseMapper esUserCourseMapper;

    @Override
    public Page<EsUserCourse> selectPage(EsUserCourse param, Page page) {
        QueryWrapper<EsUserCourse> entityWrapper = new QueryWrapper<EsUserCourse>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsUserCourse> selectList(EsUserCourse param) {
        QueryWrapper<EsUserCourse> entityWrapper = new QueryWrapper<EsUserCourse>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsUserCourse> getEntityWrapper(QueryWrapper<EsUserCourse> entityWrapper,EsUserCourse esUserCourse){
        QueryWrapper<EsUserCourse> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esUserCourse.getDeleted())){
            result = entityWrapper.like("DELETED",esUserCourse.getDeleted());
        }
        return result;
    }
}