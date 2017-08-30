package com.project.qa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.qa.domain.Criteria;
import com.project.qa.domain.Project;
import com.project.qa.domain.SearchCriteria;

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

	@Override
	public List<Project> listSearch(SearchCriteria criteria) throws Exception {
		return sqlSession.selectList(namespace + ".listSearch", criteria);
	}
	
	@Override
	public List<Project> listSearchForMyPage(SearchCriteria criteria, String USER_CODE) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pageStart", criteria.getPageStart());
		paramMap.put("perPageNum", criteria.getPerPageNum());
		paramMap.put("keyword", criteria.getKeyword());
		paramMap.put("searchType", criteria.getSearchType());
		paramMap.put("USER_CODE", USER_CODE);
		return sqlSession.selectList(namespace + ".listSearchForMyPage", paramMap);
	}

	@Override
	public int listSearchCount(SearchCriteria criteria) throws Exception {
		return sqlSession.selectOne(namespace + ".listSearchCount", criteria);
	}
	
	@Override
	public int listSearchCountForMyPage(SearchCriteria criteria, String USER_CODE) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pageStart", criteria.getPageStart());
		paramMap.put("perPageNum", criteria.getPerPageNum());
		paramMap.put("keyword", criteria.getKeyword());
		paramMap.put("searchType", criteria.getSearchType());
		paramMap.put("USER_CODE", USER_CODE);
		return sqlSession.selectOne(namespace + ".listSearchCountForMyPage", paramMap);
	}

	@Override
	public void addLikeUser(String aTTR_USER, int pRJ_CODE) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("PRJ_CODE", pRJ_CODE);
		paramMap.put("ATTR_USER", aTTR_USER);
		
		sqlSession.update(namespace + ".addLikeUser", paramMap);
	}
}
