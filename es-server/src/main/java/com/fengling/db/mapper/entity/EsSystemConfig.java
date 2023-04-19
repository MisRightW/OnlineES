package com.fengling.db.mapper.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.generator.db.base.LavaDo;
import java.io.Serializable;
import java.time.LocalTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 通用配置
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_system_config")
@ApiModel(value = "EsSystemConfig对象", description = "通用配置")
public class EsSystemConfig extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("预热时长")
    @TableField("prepare")
    private Integer prepare;

    @ApiModelProperty("休市开始时间")
    @TableField("rest_start")
    private LocalTime restStart;

    @ApiModelProperty("休市结束时间")
    @TableField("rest_end")
    private LocalTime restEnd;
}
