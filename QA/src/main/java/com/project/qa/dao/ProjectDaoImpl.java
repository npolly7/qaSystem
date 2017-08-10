package com.project.qa.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.qa.domain.Criteria;
import com.project.qa.domain.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	private static String namespace = "com.project.mapper.ProjectMapper";

	@Inject
	private SqlSession sqlSession;

	@Override
	public void create(Project project) throws Exception {
		sqlSession.insert(namespace + ".create", project);
	}

	@Override
	public Project selectProject(int PRJ_CODE) throws Exception {
		return sqlSession.selectOne((namespace) + ".selectProject", PRJ_CODE);
	}

	@Override
	public void update(Project project) throws Exception {
		sqlSession.update(namespace + ".update", project);
	}

	@Override
	public void delete(int PRJ_CODE) throws Exception {
		sqlSession.delete(namespace + ".delete", PRJ_CODE);
	}

	@Override
	public List<Project> listAll() throws Exception {
		return sqlSession.selectList(namespace + ".listAll");
	}

	@Override
	public List<Project> listCriteria(Criteria criteria) throws Exception {
		
		return sqlSession.selectList(namespace+ ".listCriteria", criteria);
	}

	@Override
	public int countPaging(Criteria criteria) throws Exception {
		
		return sqlSession.selectOne(namespace +".countPaging", criteria);
	}

}
