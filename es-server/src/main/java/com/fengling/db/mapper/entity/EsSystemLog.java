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
 * 系统日志
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_system_log")
@ApiModel(value = "EsSystemLog对象", description = "系统日志")
public class EsSystemLog extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("日志名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("用户名称")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("IP地址")
    @TableField("ip")
    private String ip;

    @ApiModelProperty("IP归属地")
    @TableField("ip_region")
    private String ipRegion;

    @ApiModelProperty("日志明细")
    @TableField("detail")
    private String detail;
}
