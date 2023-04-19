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
 * 试卷考题备选答案
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_paper_question_answer")
@ApiModel(value = "EsPaperQuestionAnswer对象", description = "试卷考题备选答案")
public class EsPaperQuestionAnswer extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("试卷ID")
    @TableField("paper_id")
    private Long paperId;

    @ApiModelProperty("回答项ID")
    @TableField("answer_id")
    private Long answerId;

    @ApiModelProperty("题目ID")
    @TableField("question_id")
    private Long questionId;

    @ApiModelProperty("是否正确项")
    @TableField("is_right")
    private Integer isRight;

    @ApiModelProperty("是否选中")
    @TableField("checked")
    private Integer checked;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("选项标签")
    @TableField("type")
    private String type;
}
