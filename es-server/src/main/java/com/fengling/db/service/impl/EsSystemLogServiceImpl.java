package com.fengling.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsSystemLog;
import com.fengling.db.mapper.EsSystemLogMapper;
import com.fengling.db.service.IEsSystemLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Service
@Transactional
public class EsSystemLogServiceImpl extends ServiceImpl<EsSystemLogMapper, EsSystemLog> implements IEsSystemLogService {


    @Autowired
    private EsSystemLogMapper esSystemLogMapper;

    @Override
    public Page<EsSystemLog> selectPage(EsSystemLog param, Page page) {
        QueryWrapper<EsSystemLog> entityWrapper = new QueryWrapper<EsSystemLog>();
        getEntityWrapper(entityWrapper,param);
        return super.page(page, entityWrapper);
    }

    @Override
    public List<EsSystemLog> selectList(EsSystemLog param) {
        QueryWrapper<EsSystemLog> entityWrapper = new QueryWrapper<EsSystemLog>();
        getEntityWrapper(entityWrapper, param);
        return super.list(entityWrapper);
    }

    /**
     *  公共查询条件
     * @param entityWrapper
     * @return
     */
    public QueryWrapper<EsSystemLog> getEntityWrapper(QueryWrapper<EsSystemLog> entityWrapper,EsSystemLog esSystemLog){
        QueryWrapper<EsSystemLog> result = null;
        //条件拼接
        if (StringUtils.isNotBlank(esSystemLog.getDeleted())){
            result = entityWrapper.like("DELETED",esSystemLog.getDeleted());
        }
        if (StringUtils.isNotBlank(esSystemLog.getTitle())){
            result = entityWrapper.like("TITLE",esSystemLog.getTitle());
        }
        if (StringUtils.isNotBlank(esSystemLog.getUserName())){
            result = entityWrapper.like("USER_NAME",esSystemLog.getUserName());
        }
        if (StringUtils.isNotBlank(esSystemLog.getIp())){
            result = entityWrapper.like("IP",esSystemLog.getIp());
        }
        if (StringUtils.isNotBlank(esSystemLog.getIpRegion())){
            result = entityWrapper.like("IP_REGION",esSystemLog.getIpRegion());
        }
        if (StringUtils.isNotBlank(esSystemLog.getDetail())){
            result = entityWrapper.like("DETAIL",esSystemLog.getDetail());
        }
        return result;
    }
}