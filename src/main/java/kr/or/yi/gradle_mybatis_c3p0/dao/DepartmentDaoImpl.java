package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MybatisSqlSessionFactory;

public class DepartmentDaoImpl implements DepartmentDao {
	private static final String nameSpace = "kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao";
	
	@Override
	public List<Department> selectDepartmentByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(nameSpace + ".selectDepartmentByAll");
		}
	}

	@Override
	public int insertDepartment(Department department) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(nameSpace + ".insertDepartment", department);
			sqlSession.commit();
			return res;	
		}
	}

	@Override
	public int deleteDepartment(Department department) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(nameSpace + ".deleteDepartment", department);
			sqlSession.commit();
			return res;	
		}
	}

	@Override
	public int updateDepartment(Department department) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(nameSpace + ".updateDepartment", department);
			sqlSession.commit();
			return res;	
		}
	}

	@Override
	public Department selectDepartmentByCode(Department department) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(nameSpace + ".selectDepartmentByCode", department);
		}
	}

}
