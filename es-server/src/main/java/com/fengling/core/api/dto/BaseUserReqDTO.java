package com.fengling.core.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户通用请求类
 * @author fengl
 */
@Data
@ApiModel(value="用户通用请求类", description="用户通用请求类")
@AllArgsConstructor
@NoArgsConstructor
public class BaseUserReqDTO extends BaseDTO {


    @JsonIgnore
    @ApiModelProperty(value = "用户ID用来注入用的，可以不传")
    private String userId;

}
