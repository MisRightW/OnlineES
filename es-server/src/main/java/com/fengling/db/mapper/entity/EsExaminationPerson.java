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
 * 
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_examination_person")
@ApiModel(value = "EsExaminationPerson对象", description = "")
public class EsExaminationPerson extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("考试ID")
    @TableField("exam_id")
    private Long examId;

    @ApiModelProperty("最高分数")
    @TableField("max_score")
    private Integer maxScore;

    @ApiModelProperty("是否合格")
    @TableField("is_pass")
    private Integer isPass;

    @ApiModelProperty("考试次数")
    @TableField("exam_count")
    private Integer examCount;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;
}
