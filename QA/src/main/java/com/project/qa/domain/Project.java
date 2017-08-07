package com.project.qa.domain;

import java.util.Date;

public class Project {

	private String projectCode;
	private String projectName;
	private String writerId;
	private String likeList;
	private Date regDate;
	private Date updateDate;
	
	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getProjectCode() {
		return projectCode;
	}
	
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getLikeList() {
		return likeList;
	}
	
	public void setLikeList(String likeList) {
		this.likeList = likeList;
	}
	
	
}
