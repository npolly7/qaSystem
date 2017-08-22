package com.project.qa.domain;

import java.util.Date;

public class Project {

	private String PRJ_CODE;
	private String PRJ_NAME;
	private int PM;
	private String CLIENT;
	private String ATT_USER;
	private String START_DATE;
	private String END_DATE;
	private String WR_DATE;
	private String UPDT_DATE;
	
	public String getPRJ_CODE() {
		return PRJ_CODE;
	}

	public void setPRJ_CODE(String pRJ_CODE) {
		PRJ_CODE = pRJ_CODE;
	}

	public String getPRJ_NAME() {
		return PRJ_NAME;
	}

	public void setPRJ_NAME(String pRJ_NAME) {
		PRJ_NAME = pRJ_NAME;
	}

	public int getPM() {
		return PM;
	}

	public void setPM(int pM) {
		PM = pM;
	}

	public String getCLIENT() {
		return CLIENT;
	}

	public void setCLIENT(String cLIENT) {
		CLIENT = cLIENT;
	}

	public String getATT_USER() {
		return ATT_USER;
	}

	public void setATT_USER(String aTT_USER) {
		ATT_USER = aTT_USER;
	}

	public String getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public String getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	}

	public String getWR_DATE() {
		return WR_DATE;
	}

	public void setWR_DATE(String wR_DATE) {
		WR_DATE = wR_DATE;
	}

	public String getUPDT_DATE() {
		return UPDT_DATE;
	}

	public void setUPDT_DATE(String uPDT_DATE) {
		UPDT_DATE = uPDT_DATE;
	}

	@Override
	public String toString() {
		return "Project [PRJ_NAME=" + PRJ_NAME + ", PM=" + PM + ", CLIENT=" + CLIENT + ", ATT_USER=" + ATT_USER
				+ ", START_DATE=" + START_DATE + ", END_DATE=" + END_DATE + ", WR_DATE=" + WR_DATE + ", UPDT_DATE="
				+ UPDT_DATE + "]";
	}

	
	
}
