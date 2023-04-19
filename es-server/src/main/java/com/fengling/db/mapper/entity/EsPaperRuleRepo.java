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
 * 规则题库
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_paper_rule_repo")
@ApiModel(value = "EsPaperRuleRepo对象", description = "规则题库")
public class EsPaperRuleRepo extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("规则ID")
    @TableField("rule_id")
    private Long ruleId;

    @ApiModelProperty("题库ID")
    @TableField("repo_id")
    private Long repoId;

    @ApiModelProperty("单选题数量")
    @TableField("radio_count")
    private Integer radioCount;

    @ApiModelProperty("单选题分数")
    @TableField("radio_score")
    private Integer radioScore;

    @ApiModelProperty("多选题数量")
    @TableField("multi_count")
    private Integer multiCount;

    @ApiModelProperty("多选题分数")
    @TableField("multi_score")
    private Integer multiScore;

    @ApiModelProperty("判断题数量")
    @TableField("judge_count")
    private Integer judgeCount;

    @ApiModelProperty("判断题分数")
    @TableField("judge_score")
    private Integer judgeScore;

    @ApiModelProperty("简答题数量")
    @TableField("saq_count")
    private Integer saqCount;

    @ApiModelProperty("简答题分数")
    @TableField("saq_score")
    private Integer saqScore;
}
