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
 * 试题题库
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_question_repo_ref")
@ApiModel(value = "EsQuestionRepoRef对象", description = "试题题库")
public class EsQuestionRepoRef extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("试题")
    @TableField("question_id")
    private Long questionId;

    @ApiModelProperty("归属题库")
    @TableField("repo_id")
    private Long repoId;

    @ApiModelProperty("题目类型")
    @TableField("question_type")
    private Integer questionType;
}
