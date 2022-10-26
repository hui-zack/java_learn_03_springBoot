package com.hui.exception;
/* 1-3 自定义SystemException异常类 */
public class SystemException extends RuntimeException{
    private final Integer exceptionCode;

    public SystemException(Integer exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public SystemException(Integer exceptionCode, String message, Throwable cause) {
        super(message, cause);
        this.exceptionCode = exceptionCode;
    }

    public Integer getExceptionCode() {
        return exceptionCode;
    }
}
