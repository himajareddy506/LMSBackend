package com.hcl.lms.dto;

import java.io.Serializable;

public class LoginRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String emailId;
	private String passcode;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public LoginRequestDto() {
		super();
	}
	
}
