package com.project.qa.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import com.project.qa.domain.User;

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
	public User selectUser(String userId) throws Exception {
		return (User)sqlSession.selectOne(namespace + ".selectUser", userId);
	}

	@Override
	public User selectWithPW(String userId, String password) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("password", password);
		
		return (User)sqlSession.selectOne(namespace+".selectWithPW", paramMap);
	}

}
