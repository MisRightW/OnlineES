package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestionAnswer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 候选答案 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsQuestionAnswerService extends IService<EsQuestionAnswer> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsQuestionAnswer> selectPage(EsQuestionAnswer param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsQuestionAnswer> selectList(EsQuestionAnswer param);

}