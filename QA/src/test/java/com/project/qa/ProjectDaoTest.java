package com.project.qa;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.qa.dao.ProjectDao;
import com.project.qa.domain.Project;
import com.project.qa.domain.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ProjectDaoTest {

	@Inject
	private ProjectDao projectDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectDaoTest.class);
	
	@Test
	public void testCreate() throws Exception{
		Project project = new Project();
		
		project.setPRJ_NAME("Project1");
		project.setPM(1);
		project.setCLIENT("넥스젠");
		
		projectDao.create(project);
	}
	
	@Test
	public void testSelect() throws Exception{
		
		System.out.println(projectDao.selectProject(1).toString());
	}
	
	@Test
	public void testDynamic() throws Exception{
	
		SearchCriteria criteria = new SearchCriteria();
		criteria.setPage(1);;
		criteria.setKeyword("project");
		criteria.setSearchType("nm");
		
		logger.info("==========================================");
		
		List<Project> list = projectDao.listSearch(criteria);
		
		for( Project project : list) {
			logger.info(project.getPRJ_CODE() + ": " + project.getPRJ_NAME());
		}
		
		logger.info("===============================================");
		
		logger.info("COUNT : " + projectDao.listSearchCount(criteria));
		
	}
	
}
