package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsSystemConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 通用配置 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsSystemConfigService extends IService<EsSystemConfig> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsSystemConfig> selectPage(EsSystemConfig param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsSystemConfig> selectList(EsSystemConfig param);

}