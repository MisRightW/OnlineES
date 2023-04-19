package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsSystemLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsSystemLogService extends IService<EsSystemLog> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsSystemLog> selectPage(EsSystemLog param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsSystemLog> selectList(EsSystemLog param);

}