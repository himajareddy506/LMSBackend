package com.hcl.lms.dto;

import java.io.Serializable;

public class LoginResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Integer statusCode;
	private String message;
	
	public Integer getUserrId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LoginResponseDto() {
		super();
	}
	
}
