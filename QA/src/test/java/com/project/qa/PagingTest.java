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
import com.project.qa.domain.Criteria;
import com.project.qa.domain.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class PagingTest {

	private static final Logger logger = LoggerFactory.getLogger(PagingTest.class);
	
	@Inject
	private ProjectDao projectDao;
	
	@Test
	public void testListCriteria() throws Exception{
		
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(10);
		
		List<Project> list = projectDao.listCriteria(cri);
		
		for(Project project : list) {
			logger.info(project.getPRJ_CODE() + " : "+ project.getPRJ_NAME());
		}
	}
	
}
