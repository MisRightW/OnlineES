package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsUserWrongBook;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 错题本 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsUserWrongBookService extends IService<EsUserWrongBook> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsUserWrongBook> selectPage(EsUserWrongBook param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsUserWrongBook> selectList(EsUserWrongBook param);

}