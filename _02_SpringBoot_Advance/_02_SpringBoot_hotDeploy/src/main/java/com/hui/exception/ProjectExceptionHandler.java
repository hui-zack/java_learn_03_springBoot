package com.hui.exception;

import com.hui.controller.code.Code;
import com.hui.controller.dataResponse.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/* 设置异常处理器 (@RestControllerAdvice注解-所属包需被SpringMvcConfig扫描到) */

@RestControllerAdvice               //拦截所有controller, 并将所有返回值写入响应体; @ControllerAdvice                   //拦截所有controller
public class ProjectExceptionHandler {
    /* 处理业务异常 使用@ExceptionHandler() */
    @ExceptionHandler(SystemException.class)
    public Result dealSystemException(SystemException e){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员, 异常对象发送给开发人员
        System.out.println("[SystemException] " + e.getLocalizedMessage());
        return new Result(e.getExceptionCode(), null, e.getMessage());
    }

    /* 处理系统异常 使用@ExceptionHandler() */
    @ExceptionHandler(BusinessException.class)
    public Result dealBusinessException(BusinessException e){
        //记录日志
        //发送消息给运维
        System.out.println("[BusinessException] " + e.getLocalizedMessage());
        return new Result(e.getExceptionCode(), null, e.getMessage());
    }


    /* 处理未知异常  使用@ExceptionHandler()*/
    @ExceptionHandler(Exception.class)
    public Result dealUnknownException(Exception e){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员, 异常对象发送给开发人员
        System.out.println("[UnknownException] " + e.getLocalizedMessage());
        e.printStackTrace();
        return new Result(Code.SYSTEM_UNKNOWN_ERROR, null, "系统繁忙, 请稍后再试...");
    }
}
