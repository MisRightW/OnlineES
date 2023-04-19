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
 * 试卷
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_paper")
@ApiModel(value = "EsPaper对象", description = "试卷")
public class EsPaper extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("规则ID")
    @TableField("exam_id")
    private Long examId;

    @ApiModelProperty("考试标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("考试时长")
    @TableField("total_time")
    private Integer totalTime;

    @ApiModelProperty("用户时长")
    @TableField("user_time")
    private Integer userTime;

    @ApiModelProperty("试卷总分")
    @TableField("total_score")
    private Integer totalScore;

    @ApiModelProperty("及格分")
    @TableField("qualify_score")
    private Integer qualifyScore;

    @ApiModelProperty("客观分")
    @TableField("obj_score")
    private Integer objScore;

    @ApiModelProperty("主观分")
    @TableField("subj_score")
    private Integer subjScore;

    @ApiModelProperty("用户得分")
    @TableField("user_score")
    private Integer userScore;

    @ApiModelProperty("是否包含简答题")
    @TableField("has_saq")
    private Integer hasSaq;

    @ApiModelProperty("试卷状态")
    @TableField("state")
    private Integer state;
}
