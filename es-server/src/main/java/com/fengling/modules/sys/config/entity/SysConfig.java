package com.fengling.modules.sys.config.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
* 通用配置实体类
 * @author fengl
 */
@Data
@TableName("sys_config")
public class SysConfig extends Model<SysConfig> {

    private static final long serialVersionUID = 1L;
    
    /**
    * ID
    */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    
    /**
    * 预热时长
    */
    private Integer prepare;
    
    /**
    * 休市开始时间
    */
    @TableField("rest_start")
    private Date restStart;
    
    /**
    * 休市结束时间
    */
    @TableField("rest_end")
    private Date restEnd;
    
}
