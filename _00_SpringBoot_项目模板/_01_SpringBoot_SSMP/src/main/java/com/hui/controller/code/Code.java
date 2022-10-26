package com.hui.controller.code;

public class Code {
    /* 正确响应码 */
    public static Integer SAVE_OK = 20011;
    public static Integer DELETE_OK = 20021;
    public static Integer UPDATE_OK = 20031;
    public static Integer GET_OK = 20041;

    /* 错误响应码 */
    public static Integer SAVE_ERROR = 20010;
    public static Integer DELETE_ERROR = 20020;
    public static Integer UPDATE_ERROR = 20030;
    public static Integer GET_ERROR = 20040;

    /* 编写Code设置异常响应码 */

    /* 系统异常响应码 */
    public static Integer SYSTEM_ERROR = 50001;
    public static Integer SYSTEM_TIME_ERROR = 50002;

    /* 业务异常响应码 */
    public static Integer BUSINESS_ERROR = 60001;

    /* 未知异常响应码 */
    public static Integer SYSTEM_UNKNOWN_ERROR = 5999;
}
