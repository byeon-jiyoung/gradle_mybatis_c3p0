package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MybatisSqlSessionFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final String nameSpace = "kr.or.yi.gradle_mybatis_c3p0.dao.EmployeeDao";
	
	@Override
	public List<Employee> selectEmployeeByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(nameSpace + ".selectDepartmentByAll");
		}
	}

	@Override
	public int insertEmployee(Employee employee) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(nameSpace + ".insertEmployee", employee);
			sqlSession.commit();
			return res;	
		}
	}

	@Override
	public int deleteEmployee(Employee employee) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(nameSpace + ".deleteEmployee", employee);
			sqlSession.commit();
			return res;	
		}
	}

	@Override
	public int updateEmployee(Employee employee) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(nameSpace + ".updateEmployee", employee);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Employee selectEmployeeByCode(Employee employee) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(nameSpace + ".selectEmployeeByCode", employee);
		}
	}

}
