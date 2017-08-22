package com.project.qa.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.qa.dao.ProjectDao;
import com.project.qa.domain.Criteria;
import com.project.qa.domain.Project;
import com.project.qa.domain.SearchCriteria;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Inject
	private ProjectDao projectDao;
	
	@Override
	public void regist(Project project) throws Exception {
		projectDao.create(project);
	}

	@Override
	public Project read(int PRJ_CODE) throws Exception {
		return projectDao.selectProject(PRJ_CODE);
	}

	@Override
	public void modify(Project project) throws Exception {
		projectDao.update(project);
	}

	@Override
	public void remove(int PRJ_CODE) throws Exception {
		projectDao.delete(PRJ_CODE);
	}

	@Override
	public List<Project> listAll() throws Exception {
		return projectDao.listAll();
	}

	@Override
	public List<Project> listCriteria(Criteria criteria) throws Exception {
		return projectDao.listCriteria(criteria);
	}

	@Override
	public int listCountCriteria(Criteria criteria) throws Exception {
		
		return projectDao.countPaging(criteria);
	}

	@Override
	public List<Project> listSearchCriteria(SearchCriteria criteria) throws Exception {
		return projectDao.listSearch(criteria);
	}

	@Override
	public int listSearchCount(SearchCriteria criteria) throws Exception {
		return projectDao.listSearchCount(criteria);
	}

}
