package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsPaperQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 试卷考题 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsPaperQuestionService extends IService<EsPaperQuestion> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsPaperQuestion> selectPage(EsPaperQuestion param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsPaperQuestion> selectList(EsPaperQuestion param);

}