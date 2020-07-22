package com.fr.commom.utils;



/**
 * Ajax结果集
 * @author Perfree
 */

public class AjaxResult {

	/**ajax响应码500出错*/
	public static final int AJAX_ERROR = 500;
	/**ajax响应码200成功*/
	public static final int AJAX_SUCCESS = 200;
	
	/**
	 * Ajax结果集
	 * @param state 状态
	 * @param msg 信息
	 * @param data 数据
	 */
	public AjaxResult(Integer state, String msg, Object data) {
		this.state = state;
		this.msg = msg;
		this.data = data;
	}
	
	/**
	 * Ajax结果集
	 * @param state 状态
	 * @param msg 信息
	 */
	public AjaxResult(Integer state, String msg) {
		this.state = state;
		this.msg = msg;
	}
	
	/**
	 * Ajax结果集
	 * @param state 状态
	 */
	public AjaxResult(Integer state) {
		this.state = state;
	}
	
	/**
	 * Ajax结果集
	 * @param state 状态
	 * @param data 数据
	 */
	public AjaxResult(Integer state, Object data) {
		this.state = state;
		this.data = data;
	}
	
	private Integer state;
	private String msg;
	private Object data;

	public static int getAjaxError() {
		return AJAX_ERROR;
	}

	public static int getAjaxSuccess() {
		return AJAX_SUCCESS;
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
