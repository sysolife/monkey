package com.bulldog.monkey.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *   暂时解决不了异常的优先级问题，
 *   此拦截器优先级大于局部拦截器，暂时不使用
 *
 * @author lijian
 *
 * @date 2019/11/5
 *
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String errorHandler(Exception e) {
        return "global error:" + e.getClass().getName();
    }
}