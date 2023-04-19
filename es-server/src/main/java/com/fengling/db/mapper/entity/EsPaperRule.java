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
 * 试卷规则
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_paper_rule")
@ApiModel(value = "EsPaperRule对象", description = "试卷规则")
public class EsPaperRule extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("规则名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("主观题分数")
    @TableField("subj_score")
    private Integer subjScore;

    @ApiModelProperty("客观题分数")
    @TableField("obj_score")
    private Integer objScore;

    @ApiModelProperty("总分")
    @TableField("total_score")
    private Integer totalScore;

    @ApiModelProperty("时长(分钟)")
    @TableField("total_time")
    private Integer totalTime;

    @ApiModelProperty("备注信息")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("规则编号")
    @TableField("code")
    private String code;

    @ApiModelProperty("状态")
    @TableField("state")
    private Integer state;

    @ApiModelProperty("合格分数线")
    @TableField("qualify_score")
    private Integer qualifyScore;
}
