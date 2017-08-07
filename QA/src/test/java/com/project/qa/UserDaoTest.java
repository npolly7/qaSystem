package com.project.qa;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.qa.dao.UserDao;
import com.project.qa.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserDaoTest {

	@Inject
	private UserDao userDao;
	
	@Test
	public void testTime() throws Exception{
		System.out.println(userDao.getTime());
	}
	
	@Test
	public void testInsertUser() throws Exception{
		
		User user = new User();
		user.setUserId("user1");
		user.setPassword("12345");
		user.setUserName("TY");
		user.setPhoneNum("01022423836");
		
		userDao.insertUser(user);
	}
}
