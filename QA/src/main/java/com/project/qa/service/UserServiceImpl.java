package com.project.qa.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.qa.dao.UserDao;
import com.project.qa.domain.User;
import com.project.qa.dto.LoginDto;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserDao dao;
	
	@Override
	public User login(LoginDto dto) throws Exception {
		return dao.login(dto);
	}
	
}
