package com.fengling.core.exception;


import com.fengling.core.api.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理类
 * @author fengling
 */
@RestControllerAdvice
public class ServiceExceptionHandler {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initWebBinder(WebDataBinder binder){

    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttribute(Model model) {
        
    }

    /**
     * 捕获ServiceException
     * @param e
     * @return
     */

    @ExceptionHandler({com.fengling.core.exception.ServiceException.class})
    @ResponseStatus(HttpStatus.OK)
    public ApiResult serviceExceptionHandler(ServiceException e) {
        return new ApiResult(e);
    }

}