package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsPaper;
import com.fengling.db.mapper.EsPaperMapper;
import com.fengling.db.service.IEsPaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 试卷 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsPaperServiceImpl extends ServiceImpl<EsPaperMapper, EsPaper> implements IEsPaperService {


    @Autowired
    private EsPaperMapper esPaperMapper;

    @Override
    public Page<EsPaper> selectPage(EsPaper param, Page page) {
        QueryWrapper<EsPaper> entityWrapper = new QueryWrapper<EsPaper>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsPaper> selectList(EsPaper param) {
        QueryWrapper<EsPaper> entityWrapper = new QueryWrapper<EsPaper>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsPaper> getEntityWrapper(QueryWrapper<EsPaper> entityWrapper,EsPaper esPaper){
        QueryWrapper<EsPaper> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esPaper.getDeleted())){
            result = entityWrapper.like("DELETED",esPaper.getDeleted());
        }
        if (StringUtils.isNotBlank(esPaper.getTitle())){
            result = entityWrapper.like("TITLE",esPaper.getTitle());
        }
        return result;
    }
}