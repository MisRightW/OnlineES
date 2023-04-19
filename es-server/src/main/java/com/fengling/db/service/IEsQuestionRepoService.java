package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestionRepo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 题库 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsQuestionRepoService extends IService<EsQuestionRepo> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsQuestionRepo> selectPage(EsQuestionRepo param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsQuestionRepo> selectList(EsQuestionRepo param);

}