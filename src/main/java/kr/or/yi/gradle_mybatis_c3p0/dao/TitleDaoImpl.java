package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MybatisSqlSessionFactory;

public class TitleDaoImpl implements TitleDao {
	private static final String nameSpace = "kr.or.yi.gradle_mybatis_c3p0.dao.TitleDao";
	@Override
	public List<Title> selectTitleByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(nameSpace + ".selectTitleByAll");
		}
	}
	
}
