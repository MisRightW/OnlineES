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
 * 课件阅读记录
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_user_ware")
@ApiModel(value = "EsUserWare对象", description = "课件阅读记录")
public class EsUserWare extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("课程ID")
    @TableField("course_id")
    private Long courseId;

    @ApiModelProperty("课件ID")
    @TableField("ware_id")
    private Long wareId;

    @ApiModelProperty("需要分钟")
    @TableField("need_min")
    private Integer needMin;

    @ApiModelProperty("已读秒数")
    @TableField("learn_sec")
    private Integer learnSec;
}
