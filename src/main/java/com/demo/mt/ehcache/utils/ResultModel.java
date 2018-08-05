package com.demo.mt.ehcache.utils;

import lombok.Data;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

/**
 * ResultModel
 *
 * @author MT.LUO
 * 2018/6/6 11:33
 * @Description:
 */

// 定义Restful接口返回类，定义需要返回的数据的字段
@Data
public class ResultModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private Object object;

    public ResultModel(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultModel(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public static ResultModel ok() {
        return new ResultModel(ResultCode.OK.value(), ResultCode.OK.name());
    }

    public static ResultModel ok(String msg) {
        return new ResultModel(ResultCode.OK.value(), msg);
    }

    public static ResultModel ok(Object o) {
        return new ResultModel(ResultCode.OK.value(), ResultCode.OK.name(), o);
    }


    public static ResultModel error(ResultCode code) {
        return new ResultModel(code.value(), code.name());
    }

    public static ResultModel error(ResultCode code, String msg) {
        return new ResultModel(code.value(), msg);
    }

    public static ResultModel error(ResultCode code,  Object o) {
        return new ResultModel(code.value(), code.name(), o);
    }

    public static ResultModel error(ResultCode code, String msg, Object o) {
        return new ResultModel(code.value(), msg, o);
    }

    public static ResultModel error(BindingResult result, MessageSource messageSource) {
        StringBuffer msg = new StringBuffer();
        //获取错误字段集合
        List<FieldError> fieldErrors = result.getFieldErrors();
        //获取本地locale,zh_CN
        Locale currentLocale = LocaleContextHolder.getLocale();
        //遍历错误字段获取错误消息
        for (FieldError fieldError : fieldErrors) {
            //获取错误信息
            String errorMessage = messageSource.getMessage(fieldError, currentLocale);
            //添加到错误消息集合内
            msg.append(fieldError.getField() + "：" + errorMessage + " , ");
        }
        return error(ResultCode.PARAM_ERROR, msg);
    }

    @Override
    public String toString() {
        return "{" + "\"code\":" + code + ", \"msg\":\"" + msg  + "\", \"object\":" + object + "}";
    }
}
