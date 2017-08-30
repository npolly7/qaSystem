package com.project.qa.service;

import java.util.List;

import com.project.qa.domain.Criteria;
import com.project.qa.domain.Project;
import com.project.qa.domain.SearchCriteria;

public interface ProjectService {
	
	public void regist(Project project) throws Exception;
	
	public Project read(int PRJ_CODE) throws Exception;
	
	public void modify(Project project) throws Exception;
	
	public void remove(int PRJ_CODE) throws Exception;
	
	public List<Project> listAll() throws Exception;
	
	public List<Project> listCriteria(Criteria criteria) throws Exception;
	
	public int listCountCriteria(Criteria criteria) throws Exception;

	public int listSearchCountForMyPage(SearchCriteria criteria, String USER_CODE) throws Exception;
	
	public List<Project> listSearchCriteria(SearchCriteria criteria) throws Exception;
	
	public List<Project> ListSearchCriteriaForMyPage(SearchCriteria criteria, String USER_CODE) throws Exception;
	
	public int listSearchCount(SearchCriteria criteria) throws Exception;

	public void addLikeUser(String aTTR_USER, int pRJ_CODE) throws Exception;

}
