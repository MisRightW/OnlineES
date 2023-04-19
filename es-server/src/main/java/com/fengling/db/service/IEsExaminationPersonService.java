package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsExaminationPerson;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsExaminationPersonService extends IService<EsExaminationPerson> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsExaminationPerson> selectPage(EsExaminationPerson param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsExaminationPerson> selectList(EsExaminationPerson param);

}