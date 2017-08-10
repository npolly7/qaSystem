package com.project.qa.dao;

import java.util.List;

import com.project.qa.domain.Criteria;
import com.project.qa.domain.Project;

public interface ProjectDao {
	
	public void create(Project project) throws Exception;
	
	public Project selectProject(int PRJ_CODE) throws Exception;
	
	public void update(Project project) throws Exception;
	
	public void delete(int PRJ_CODE) throws Exception;
	
	public List<Project> listAll() throws Exception;
	
	public List<Project> listCriteria(Criteria crieria) throws Exception;
	
	public int countPaging(Criteria criteria) throws Exception;
}
