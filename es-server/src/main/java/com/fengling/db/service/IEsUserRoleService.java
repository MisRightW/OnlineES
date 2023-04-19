package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户角色 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsUserRoleService extends IService<EsUserRole> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsUserRole> selectPage(EsUserRole param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsUserRole> selectList(EsUserRole param);

}