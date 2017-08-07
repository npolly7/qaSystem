package com.project.qa.dao;

import com.project.qa.domain.User;

public interface UserDao {
	
	public String getTime();
	public void insertUser(User user);
	public User selectUser(String id) throws Exception;
	public User selectWithPW(String id, String password) throws Exception;
	
}
