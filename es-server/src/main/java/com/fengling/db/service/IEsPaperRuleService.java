package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsPaperRule;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 试卷规则 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsPaperRuleService extends IService<EsPaperRule> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsPaperRule> selectPage(EsPaperRule param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsPaperRule> selectList(EsPaperRule param);

}