package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 问题题目 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsQuestionService extends IService<EsQuestion> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsQuestion> selectPage(EsQuestion param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsQuestion> selectList(EsQuestion param);

}