package com.project.qa;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.qa.dao.ProjectDao;
import com.project.qa.domain.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ProjectDaoTest {

	@Inject
	private ProjectDao projectDao;
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
}
