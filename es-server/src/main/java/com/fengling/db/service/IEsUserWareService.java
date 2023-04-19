package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsUserWare;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课件阅读记录 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsUserWareService extends IService<EsUserWare> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsUserWare> selectPage(EsUserWare param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsUserWare> selectList(EsUserWare param);

}