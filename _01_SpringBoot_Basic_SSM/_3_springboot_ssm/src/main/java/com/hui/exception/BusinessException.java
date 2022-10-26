package com.hui.exception;
/* 1-4 自定义BusinessException异常类 */
public class BusinessException extends RuntimeException{
    private final Integer exceptionCode;

    public BusinessException(Integer exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public BusinessException(Integer exceptionCode, String message, Throwable cause) {
        super(message, cause);
        this.exceptionCode = exceptionCode;
    }

    public Integer getExceptionCode() {
        return exceptionCode;
    }
}
