package com.yyy.dailycode.exception;

import java.text.MessageFormat;

import com.yyy.dailycode.exception.loadproperties.LoadErrorProperties;

/**
 *   @类名： XxcjException
 *   @描述： 自定义异常
 *   @作者： 杨文胜
 *   @生成时间： Jul 31, 2014 1:05:08 PM
 *   @修改人：
 *   @修改时间：  
 **/
public class CommonException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * @属性说明： 错误编码
	 */
	private String errorCode;
	/**
	 * @属性说明： 错误信息
	 */
	private String errorMsg;
	
	public CommonException() {
		super();
	}
	private CommonException(String message, Throwable cause){
		super();
	}
	public CommonException(String errorCode) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = LoadErrorProperties.getValue(errorCode);
	}
	public CommonException(String errorCode, Object[] params) {
		String message = LoadErrorProperties.getValue(errorCode);
		message = MessageFormat.format(message, params);
		this.errorMsg = message;
		this.errorCode = errorCode;
		new CommonException(errorMsg);
	}
	/**
	 * @param cause
	 * @param errorCode 自定义的错误码
	 */
	public CommonException(String errorCode, Throwable cause, Object[] params) {
		String message = LoadErrorProperties.getValue(errorCode);
		message = MessageFormat.format(message, params);
		this.errorMsg = message;
		this.errorCode = errorCode;
		new CommonException(message, cause);
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
