package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsPaperRuleRepo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 规则题库 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsPaperRuleRepoService extends IService<EsPaperRuleRepo> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsPaperRuleRepo> selectPage(EsPaperRuleRepo param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsPaperRuleRepo> selectList(EsPaperRuleRepo param);

}