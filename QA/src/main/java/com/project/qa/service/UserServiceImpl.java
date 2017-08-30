package com.project.qa.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.qa.dao.UserDao;
import com.project.qa.domain.User;
import com.project.qa.dto.LoginDto;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserDao userDao;
	
	@Override
	public User login(LoginDto dto) throws Exception {
		return userDao.login(dto);
	}

	@Override
	public void addLikePrj(String uSER_CODE, String aTTR_PRJ) throws Exception {
		userDao.addLikeUser(uSER_CODE, aTTR_PRJ);
	}

	@Override
	public User read(String USER_CODE) throws Exception {
		return userDao.selectUser(USER_CODE);
	}
	
}
