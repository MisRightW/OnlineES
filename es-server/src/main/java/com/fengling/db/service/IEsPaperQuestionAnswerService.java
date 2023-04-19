package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsPaperQuestionAnswer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 试卷考题备选答案 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsPaperQuestionAnswerService extends IService<EsPaperQuestionAnswer> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsPaperQuestionAnswer> selectPage(EsPaperQuestionAnswer param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsPaperQuestionAnswer> selectList(EsPaperQuestionAnswer param);

}