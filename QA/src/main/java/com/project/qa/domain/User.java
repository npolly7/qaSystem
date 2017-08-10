package com.project.qa.domain;

import java.util.Date;

public class User {
	private int USER_CODE;
	private String USER_ID;
	private String USER_PW;
	private String USER_NAME;
	private String USER_PHONE;
	private String USER_BIRTH;
	private Date WR_DATE;
	private Date UPDT_DATE;
	
	
	
	public int getUSER_CODE() {
		return USER_CODE;
	}
	public void setUSER_CODE(int uSER_CODE) {
		USER_CODE = uSER_CODE;
	}
	
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
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_PHONE() {
		return USER_PHONE;
	}
	public void setUSER_PHONE(String uSER_PHONE) {
		USER_PHONE = uSER_PHONE;
	}
	public String getUSER_BIRTH() {
		return USER_BIRTH;
	}
	public void setUSER_BIRTH(String uSER_BIRTH) {
		USER_BIRTH = uSER_BIRTH;
	}
	public Date getWR_DATE() {
		return WR_DATE;
	}
	public void setWR_DATE(Date wR_DATE) {
		WR_DATE = wR_DATE;
	}
	public Date getUPDT_DATE() {
		return UPDT_DATE;
	}
	public void setUPDT_DATE(Date uPDT_DATE) {
		UPDT_DATE = uPDT_DATE;
	}
	@Override
	public String toString() {
		return "User [USER_ID=" + USER_ID + ", USER_PW=" + USER_PW + ", USER_NAME="
				+ USER_NAME + ", USER_PHONE=" + USER_PHONE + ", USER_BIRTH=" + USER_BIRTH + ", WR_DATE=" + WR_DATE
				+ ", UPDT_DATE=" + UPDT_DATE + "]";
	}
	
}
