package com.project.qa.dto;

public class LoginDto {

	private String USER_ID;
	private String USER_PW;
	private boolean USER_COOKIE;
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_PW() {
		return USER_PW;
	}
	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}
	public boolean isUSER_COOKIE() {
		return USER_COOKIE;
	}
	public void setUSER_COOKIE(boolean uSER_COOKIE) {
		USER_COOKIE = uSER_COOKIE;
	}
	@Override
	public String toString() {
		return "LoginDto [USER_ID=" + USER_ID + ", USER_PW=" + USER_PW + ", USER_COOKIE=" + USER_COOKIE + "]";
	}
	
	
	
	
	
}
