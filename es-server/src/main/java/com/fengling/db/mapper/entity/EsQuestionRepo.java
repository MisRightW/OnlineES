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
 * 题库
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_question_repo")
@ApiModel(value = "EsQuestionRepo对象", description = "题库")
public class EsQuestionRepo extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("题库编号")
    @TableField("code")
    private String code;

    @ApiModelProperty("题库名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("题库备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
