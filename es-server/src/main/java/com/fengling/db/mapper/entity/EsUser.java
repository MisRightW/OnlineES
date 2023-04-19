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
 * 管理用户
 * </p>
 *
 * @author fengling
 * @since 2023-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("es_user")
@ApiModel(value = "EsUser对象", description = "管理用户")
public class EsUser extends LavaDo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("删除标记")
    @TableField("deleted")
    private String deleted;

    @ApiModelProperty("用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("真实姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("密码盐")
    @TableField("salt")
    private String salt;

    @ApiModelProperty("角色列表")
    @TableField("role_ids")
    private String roleIds;

    @ApiModelProperty("状态")
    @TableField("state")
    private Integer state;
}
