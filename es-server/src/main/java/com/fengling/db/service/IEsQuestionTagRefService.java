package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestionTagRef;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 题目标签 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsQuestionTagRefService extends IService<EsQuestionTagRef> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsQuestionTagRef> selectPage(EsQuestionTagRef param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsQuestionTagRef> selectList(EsQuestionTagRef param);

}