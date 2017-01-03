package com.xionglindong.bean;

public class ErrorInfo<T> {
	
	public static final Integer IS_OK = 0;
	public static final Integer IS_ERROR = 100;
	
	/**消息类型*/
	private Integer code;
	/**消息内容*/
	private String message;
	/**请求的url*/
	private String url;
	/**请求返回的数据*/
	private T date;
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public T getDate() {
		return date;
	}
	public void setDate(T date) {
		this.date = date;
	}
	
	

}
