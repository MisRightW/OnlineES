package com.fengling.core.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 通用状态请求类
 * @author fengl
 */
@Data
@ApiModel(value="通用状态请求类", description="通用状态请求类")
@AllArgsConstructor
@NoArgsConstructor
public class BaseStateReqDTO extends BaseDTO {


    @ApiModelProperty(value = "要修改对象的ID列表", required=true)
    private List<String> ids;

    @ApiModelProperty(value = "通用状态，0为正常，1为禁用", required=true)
    private Integer state;
}
