package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 管理用户 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsUserService extends IService<EsUser> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsUser> selectPage(EsUser param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsUser> selectList(EsUser param);

}