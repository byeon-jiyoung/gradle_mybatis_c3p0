package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.dto.State;
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

	//146p
	@Override
	public Map<String, Object> getSalaryByDepartment(Map<String, Object> param) {
		Map<String, Object> map = new HashMap<String, Object>();
		ResultHandler<State> resultHandler = new ResultHandler<State>() { //state클래스에 담아서 던져주겠다
		//대용량데이터 or Map일 경우에 ResultHandler사용가능
			
			@Override
			public void handleResult(ResultContext<? extends State> resultContext) {
				State state = resultContext.getResultObject();
				map.put(state.getDeptname(), state.getTotal());
			}
		};
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			sqlSession.select(nameSpace + ".getSalaryByDepartment", param, resultHandler); //select한 결과를 resultHandler에 담는다
		}
		return map;
	}

	//147p
	@Override
	public State getStateSalaryByDepartment(Map<String, Object> param) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(nameSpace + ".getStateSalaryByDepartment", param);
		}
	}

}
