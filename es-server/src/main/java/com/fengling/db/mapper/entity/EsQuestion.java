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
 * 问题题目
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_question")
@ApiModel(value = "EsQuestion对象", description = "问题题目")
public class EsQuestion extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("题目类型")
    @TableField("question_type")
    private Integer questionType;

    @ApiModelProperty("题目内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("题目图片")
    @TableField("image")
    private String image;

    @ApiModelProperty("题目视频")
    @TableField("video")
    private String video;

    @ApiModelProperty("题目备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("整题解析")
    @TableField("analysis")
    private String analysis;
}
