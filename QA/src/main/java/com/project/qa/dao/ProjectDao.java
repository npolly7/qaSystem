package com.project.qa.dao;

import java.util.List;

import com.project.qa.domain.Criteria;
import com.project.qa.domain.Project;
import com.project.qa.domain.SearchCriteria;

public interface ProjectDao {
	
	public void create(Project project) throws Exception;
	
	public Project selectProject(int PRJ_CODE) throws Exception;
	
	public void update(Project project) throws Exception;
	
	public void delete(int PRJ_CODE) throws Exception;
	
	public List<Project> listAll() throws Exception;
	
	public List<Project> listCriteria(Criteria crieria) throws Exception;
	
	public List<Project> listSearch(SearchCriteria criteria) throws Exception;
	
	public List<Project> listSearchForMyPage(SearchCriteria criteria, String USER_CODE) throws Exception;
	
	public int listSearchCount(SearchCriteria criteria) throws Exception;
	
	public int listSearchCountForMyPage(SearchCriteria criteria, String USER_CODE) throws Exception;
	
	public int countPaging(Criteria criteria) throws Exception;

	public void addLikeUser(String aTTR_USER, int pRJ_CODE) throws Exception;
}
