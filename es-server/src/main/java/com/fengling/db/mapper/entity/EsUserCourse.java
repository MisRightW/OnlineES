package com.fengling.db.mapper.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.generator.db.base.LavaDo;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户课程状态
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_user_course")
@ApiModel(value = "EsUserCourse对象", description = "用户课程状态")
public class EsUserCourse extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("课程ID")
    @TableField("course_id")
    private Long courseId;

    @ApiModelProperty("学习状态")
    @TableField("study_state")
    private Integer studyState;

    @ApiModelProperty("考试状态")
    @TableField("exam_state")
    private Integer examState;

    @ApiModelProperty("考试结果")
    @TableField("exam_result")
    private Integer examResult;

    @ApiModelProperty("最高分数")
    @TableField("exam_score")
    private Integer examScore;
}
