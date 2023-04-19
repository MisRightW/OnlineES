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
 * 试卷考题
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_paper_question")
@ApiModel(value = "EsPaperQuestion对象", description = "试卷考题")
public class EsPaperQuestion extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("试卷ID")
    @TableField("paper_id")
    private Long paperId;

    @ApiModelProperty("题目ID")
    @TableField("question_id")
    private Long questionId;

    @ApiModelProperty("题目类型")
    @TableField("question_type")
    private Integer questionType;

    @ApiModelProperty("是否已答")
    @TableField("answered")
    private Integer answered;

    @ApiModelProperty("主观答案")
    @TableField("answer")
    private String answer;

    @ApiModelProperty("问题排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("单题分分值")
    @TableField("score")
    private Integer score;

    @ApiModelProperty("实际得分(主观题)")
    @TableField("actual_score")
    private Integer actualScore;

    @ApiModelProperty("是否答对")
    @TableField("is_right")
    private Integer isRight;
}
