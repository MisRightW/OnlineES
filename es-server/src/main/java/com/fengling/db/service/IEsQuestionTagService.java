package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestionTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 标签 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsQuestionTagService extends IService<EsQuestionTag> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsQuestionTag> selectPage(EsQuestionTag param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsQuestionTag> selectList(EsQuestionTag param);

}