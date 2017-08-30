package com.project.qa.service;

import java.util.ArrayList;
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
	
	@Override
	public int listSearchCountForMyPage(SearchCriteria criteria, String USER_CODE) throws Exception {
		return projectDao.listSearchCountForMyPage(criteria, USER_CODE);
	}

	@Override
	public void addLikeUser(String aTTR_USER, int pRJ_CODE) throws Exception {
		projectDao.addLikeUser(aTTR_USER, pRJ_CODE);
	}

	@Override
	public List<Project> ListSearchCriteriaForMyPage(SearchCriteria criteria, String USER_CODE) throws Exception {

//		List<Project> projectList = new ArrayList<Project>();
//		List<Project> tmpPrjList = projectDao.listSearch(criteria);
//		
//		for(int i=0; i<tmpPrjList.size(); i++) {
//			Project tmpProject = tmpPrjList.get(i);
//			
//			for(int j=0; j<attrPrjArr.length; j++) {
//				if(attrPrjArr[j].equals(tmpProject.getPRJ_CODE())){
//					projectList.add(tmpProject);
//				}
//			}
//		}
		return projectDao.listSearchForMyPage(criteria, USER_CODE);
	}
}
