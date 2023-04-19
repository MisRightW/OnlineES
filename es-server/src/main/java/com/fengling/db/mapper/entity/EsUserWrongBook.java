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
 * 错题本
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_user_wrong_book")
@ApiModel(value = "EsUserWrongBook对象", description = "错题本")
public class EsUserWrongBook extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("题目ID")
    @TableField("question_id")
    private String questionId;

    @ApiModelProperty("加入时间")
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty("最近错误时间")
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty("错误时间")
    @TableField("wrong_count")
    private Integer wrongCount;

    @ApiModelProperty("题目标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("错题序号")
    @TableField("sort")
    private Integer sort;
}
