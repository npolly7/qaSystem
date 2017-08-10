package com.project.qa.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import com.project.qa.domain.User;
import com.project.qa.dto.LoginDto;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.project.mapper.UserMapper";

	@Override
	public String getTime() {
		
		return sqlSession.selectOne(namespace + ".getTime");
	}

	@Override
	public void insertUser(User user) {
		sqlSession.insert(namespace+".insertUser", user);
	}

	@Override
	public User selectUser(String USER_ID) throws Exception {
		return (User)sqlSession.selectOne(namespace + ".selectUser", USER_ID);
	}

	@Override
	public User selectWithPW(String USER_ID, String USER_PW) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("USER_ID", USER_ID);
		paramMap.put("USER_PW", USER_PW);
		
		return (User)sqlSession.selectOne(namespace+".selectWithPW", paramMap);
	}
	
	@Override
	public User login(LoginDto dto) throws Exception {
		return (User)sqlSession.selectOne(namespace + ".login", dto);
	}

}
