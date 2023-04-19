package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsPaper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 试卷 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsPaperService extends IService<EsPaper> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsPaper> selectPage(EsPaper param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsPaper> selectList(EsPaper param);

}