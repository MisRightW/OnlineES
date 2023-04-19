package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsQuestionRepoRef;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 试题题库 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsQuestionRepoRefService extends IService<EsQuestionRepoRef> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsQuestionRepoRef> selectPage(EsQuestionRepoRef param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsQuestionRepoRef> selectList(EsQuestionRepoRef param);

}