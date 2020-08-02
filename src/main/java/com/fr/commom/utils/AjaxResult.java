package com.fr.commom.utils;


/**
 * Ajax结果集
 *
 * @author Perfree
 */

public class AjaxResult {

    /**
     * ajax响应码500出错
     */
    public static final int AJAX_ERROR = 500;
    /**
     * ajax响应码200成功
     */
    public static final int AJAX_SUCCESS = 200;

    private Integer state;
    private String msg;
    private Object data;

    public static AjaxResult OK(String msg, Object data) {
        return new AjaxResult(msg, data);
    }

    public static AjaxResult OK(String msg) {
        return new AjaxResult(msg);
    }

	public static AjaxResult OK(Object data) {
		return new AjaxResult(data);
	}

    public static AjaxResult OK() {
        return new AjaxResult(null);
    }

    public static AjaxResult ERROR() {
        return new AjaxResult(500, "请求错误", null);
    }

    public static AjaxResult ERROR(String msg) {
        return new AjaxResult(500, msg, null);
    }


    public AjaxResult(Object data) {
        this.state = 200;
        this.msg = "请求成功";
        this.data = data;
    }

    public AjaxResult(String msg) {
        this.state = 200;
        this.msg = msg;
        this.data = null;
    }

    public AjaxResult(String msg, Object data) {
        this.state = 200;
        this.msg = msg;
        this.data = data;
    }

    public AjaxResult(Integer state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    @Override
    public String toString() {
        return "AjaxResult{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
