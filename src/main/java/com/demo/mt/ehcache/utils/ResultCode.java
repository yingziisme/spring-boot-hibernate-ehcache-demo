package com.demo.mt.ehcache.utils;

/**
 * ResultCode
 *
 * @author MT.LUO
 * 2018/6/6 11:36
 * @Description:
 */
public enum ResultCode {
    OK(200, "OK"),

    USER_NOT_EXIST(100, "user is not exist"),
    USERNAME_EXIST(101, "username is exist"),
    LOGIN_ERROR(102, "login error"),
    LOGIN_FAIL(103, "username or password error"),
    AUTH_LIMIT(104, "unauthorized "),
    PARAM_ERROR(105, "request param error "),
    PASSWORD_ERROR(106, "password wrong"),

    SYSTEM_CODE_PARAM_MISS(1001, "Request Param Miss"),
    SYSTEM_CODE_PARAM_ERROR(1002, "Request Param ERROR"),
    SYSTEM_CODE_PARAM_NOT_VALID(1003, "Request Param Not Valid"),
    SYSTEM_CODE_BIND_ERROR(1004, "Bind Error"),
    SYSTEM_CODE_CONSTRAINT_VIOLATION(1005, "Hibernate Constraint Violation"),
    SYSTEM_CODE_VALIDATION_ERROR(1006, "Validation ERROR"),
    SYSTEM_CODE_METHOD_NOT_SUPPORT(1007, "Method Not Support"),
    SYSTEM_CODE_MEDIA_NOT_SUPPORT(1008, "Media Not Support"),
    SYSTEM_CODE_SERVICE_ERROR(1009, "Service Error"),
    SYSTEM_CODE_SERVER_ERROR(1010, "Server Error"),
    SYSTEM_CODE_DATA_INTEGRITY_VIOLATION(1011, "Data Integrity Violation"),


    MEDIA_STATUS_ERROR(2001, "Media Reply Error"),
    MEDIA_STATUS_SRC_ERROR(2002, "Media Src Error"),
    MEDIA_STATUS_SRC_CHANGE(2003, "Media Src Change");


    private final int value;
    private final String reasonPhrase;

    public int value() {
        return this.value;
    }

    ResultCode(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }
}
