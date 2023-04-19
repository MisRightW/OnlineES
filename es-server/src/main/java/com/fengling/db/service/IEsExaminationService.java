package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsExamination;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsExaminationService extends IService<EsExamination> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsExamination> selectPage(EsExamination param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsExamination> selectList(EsExamination param);

}