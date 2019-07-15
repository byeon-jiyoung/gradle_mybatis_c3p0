package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MybatisSqlSessionFactory;

public class TitleDaoImpl implements TitleDao {
	private static final String nameSpace = "kr.or.yi.gradle_mybatis_c3p0.dao.TitleDao";
											//TitleMapper.xml에 namespace의 값과 같아야 된다. 그래야 이 이름을 찾아가서 밑에 있는 소스랑 매핑을 해서 sql을 수행하는거다!!
//	private static final String nameSpace = "mapper.titleMapper";
	
	@Override
	public List<Title> selectTitleByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(nameSpace + ".selectTitleByAll");
		}
	}
	
	@Override
	public int insertTitle(Title title) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(nameSpace + ".insertTitle", title);
							   //파라미터로 값을 받아와서 넘겨줘야 되니까 param값을 넘기는 애로 선택. 즉, 매개변수를 가지고 insert하는거니까!!
			sqlSession.commit(); //select빼고는 반드시 commit을 시켜줘야 한다.★★★★★★
			return res;
		}
	}

	@Override
	public int deleteTitle(Title title) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(nameSpace + ".deleteTitle", title);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateTitle(Title title) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(nameSpace + ".updateTitle", title);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Title selectTitleByCode(Title title) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(nameSpace + ".selectTitleByCode", title);
		}
	}
	
}
