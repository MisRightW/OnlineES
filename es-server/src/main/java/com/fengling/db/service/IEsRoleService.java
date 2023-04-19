package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsRoleService extends IService<EsRole> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsRole> selectPage(EsRole param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsRole> selectList(EsRole param);

}