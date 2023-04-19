package com.fengling.db.mapper.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.generator.db.base.LavaDo;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_examination")
@ApiModel(value = "EsExamination对象", description = "课程")
public class EsExamination extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("考试名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("考试描述")
    @TableField("content")
    private String content;

    @ApiModelProperty("是否公开")
    @TableField("open")
    private Integer open;

    @ApiModelProperty("口令密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("课程状态")
    @TableField("state")
    private Integer state;

    @ApiModelProperty("考试规则ID")
    @TableField("rule_id")
    private Long ruleId;

    @ApiModelProperty("是否限时")
    @TableField("time_limit")
    private Integer timeLimit;

    @ApiModelProperty("开始时间")
    @TableField("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ApiModelProperty("结束时间")
    @TableField("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @ApiModelProperty("主观题分数")
    @TableField("subj_score")
    private Integer subjScore;

    @ApiModelProperty("客观题分数")
    @TableField("obj_score")
    private Integer objScore;

    @ApiModelProperty("总分数")
    @TableField("total_score")
    private Integer totalScore;

    @ApiModelProperty("总时长（分钟）")
    @TableField("total_time")
    private Integer totalTime;

    @ApiModelProperty("及格分数")
    @TableField("qualify_score")
    private Integer qualifyScore;
}
