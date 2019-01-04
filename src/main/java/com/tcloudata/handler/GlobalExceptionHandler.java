package com.tcloudata.handler;

import com.tcloudata.constants.ErrorType;
import com.tcloudata.domain.ErrorInfo;
import com.tcloudata.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName
 * @Description 统一异常处理
 * @Author LiuYang
 * @Date 2019/1/4/004 11:48
 * @Version 1.0
 **/
//异常处理注解
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    /*
    添加异常处理注解
    我们只需要在Controller中抛出Exception，当然我们可能会有多种不同的Exception。然后在@ControllerAdvice类
    中，根据抛出的具体Exception类型匹配@ExceptionHandler中配置的异常类型来匹配错误映射和处理
    */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e){
        ModelAndView mav=new ModelAndView();
        //设置异常值
        mav.addObject("exception",e);
        //设置请求url
        mav.addObject("url",request.getRequestURL());
        //设置返回页面名称
        mav.setViewName(DEFAULT_ERROR_VIEW);;
        return mav;
    }

    /*
    定义自定义处理异常
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> errorExceptionHandler(HttpServletRequest req, MyException e){
        ErrorInfo<String> errorInfo=new ErrorInfo<>();
        errorInfo.setCode(ErrorType.ERROR.getCode());
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(req.getRequestURI());
        errorInfo.setData("some data");
        return errorInfo;
    }
}
