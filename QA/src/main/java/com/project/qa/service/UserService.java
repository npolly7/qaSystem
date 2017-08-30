package com.project.qa.service;

import com.project.qa.domain.User;
import com.project.qa.dto.LoginDto;

public interface UserService {
	public User login(LoginDto dto) throws Exception;

	public void addLikePrj(String uSER_CODE, String aTTR_PRJ) throws Exception;
	
	public User read(String USER_CODE) throws Exception;
}
