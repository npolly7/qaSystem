package com.project.qa.dao;

import java.util.List;

import com.project.qa.domain.Project;

public interface ProjectDao {
	
	public void create(Project proejct) throws Exception;
	
	public Project selectProject(String projectCode) throws Exception;
	
	public void update(Project project) throws Exception;
	
	public void delete(String projectCode) throws Exception;
	
	public List<Project> listAll() throws Exception;
}
