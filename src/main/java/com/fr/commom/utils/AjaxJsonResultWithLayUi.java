package com.fr.commom.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @version V1.0
 * @Title: IMOOCJSONResult.java
 * @Package com.imooc.utils
 * @Description: 自定义响应数据结构(前端为LayUi框架)
 * @Copyright: Copyright (c) 2020
 */
public class AjaxJsonResultWithLayUi {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer code;

    private Integer count;
    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    @JsonIgnore
    private String ok;    // 不使用

    public static AjaxJsonResultWithLayUi build(Integer code, Integer count, String msg, Object data) {
        return new AjaxJsonResultWithLayUi(code, count, msg, data);
    }

    public static AjaxJsonResultWithLayUi build(Integer code, Integer count, String msg, Object data, String ok) {
        return new AjaxJsonResultWithLayUi(code, count, msg, data, ok);
    }

    public static AjaxJsonResultWithLayUi ok(Object data) {
        return new AjaxJsonResultWithLayUi(data);
    }

    public static AjaxJsonResultWithLayUi ok() {
        return new AjaxJsonResultWithLayUi(null);
    }

    public static AjaxJsonResultWithLayUi errorMsg(String msg) {
        return new AjaxJsonResultWithLayUi(500, 1000, msg, null);
    }

    public static AjaxJsonResultWithLayUi errorMap(Object data) {
        return new AjaxJsonResultWithLayUi(501, 1000, "error", data);
    }

    public static AjaxJsonResultWithLayUi errorTokenMsg(String msg) {
        return new AjaxJsonResultWithLayUi(502, 1000, msg, null);
    }

    public static AjaxJsonResultWithLayUi errorException(String msg) {
        return new AjaxJsonResultWithLayUi(555, 1000, msg, null);
    }

    public static AjaxJsonResultWithLayUi errorUserQQ(String msg) {
        return new AjaxJsonResultWithLayUi(556, 1000, msg, null);
    }

    public AjaxJsonResultWithLayUi() {

    }

    public AjaxJsonResultWithLayUi(Integer code, Integer count, String msg, Object data) {
        this.code = code;
        this.count = count;
        this.msg = msg;
        this.data = data;
    }

    public AjaxJsonResultWithLayUi(Integer code, Integer count, String msg, Object data, String ok) {
        this.code = code;
        this.count = count;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public AjaxJsonResultWithLayUi(Object data) {
        this.code = 0;
        this.count=1000;
        this.msg = "OK";
        this.data = data;
    }

    public static ObjectMapper getMAPPER() {
        return MAPPER;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
