package com.project.qa.dao;

import com.project.qa.domain.User;
import com.project.qa.dto.LoginDto;

public interface UserDao {
	
	public String getTime();
	public void insertUser(User user);
	public User selectUser(String USER_ID) throws Exception;
	public User selectWithPW(String USER_ID, String USER_PW) throws Exception;
	
	
	public User login(LoginDto dto) throws Exception;
	
}
