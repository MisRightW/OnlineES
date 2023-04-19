package com.fengling.core.exception;

import com.fengling.core.api.ApiError;
import com.fengling.core.api.ApiResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fengl
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException{

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 从结果初始化
     * @param apiResult
     */
    public ServiceException(ApiResult apiResult){
        this.code = apiResult.getCode();
        this.msg = apiResult.getMsg();
    }

    /**
     * 从枚举中获取参数
     * @param apiError
     */
    public ServiceException(ApiError apiError){
        this.code = apiError.getCode();
        this.msg = apiError.msg;
    }

}
