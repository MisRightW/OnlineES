package com.fengling.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengling.db.mapper.entity.EsUserCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户课程状态 服务类
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
public interface IEsUserCourseService extends IService<EsUserCourse> {

        /**
         *  分页查询
         * @param param
         * @return
         */
        Page<EsUserCourse> selectPage(EsUserCourse param, Page page);

        /**
         *  数据集
         * @param param
         * @return
         */
        List<EsUserCourse> selectList(EsUserCourse param);

}