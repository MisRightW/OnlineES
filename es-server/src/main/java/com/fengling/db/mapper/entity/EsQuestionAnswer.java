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
 * 候选答案
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_question_answer")
@ApiModel(value = "EsQuestionAnswer对象", description = "候选答案")
public class EsQuestionAnswer extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("问题ID")
    @TableField("question_id")
    private Long questionId;

    @ApiModelProperty("是否正确")
    @TableField("is_right")
    private Integer isRight;

    @ApiModelProperty("答案内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("图片地址")
    @TableField("image")
    private String image;

    @ApiModelProperty("答案分析")
    @TableField("analysis")
    private String analysis;
}
