package kr.or.yi.gradle_mybatis_c3p0.service;


import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MybatisSqlSessionFactory;

public class TransactionService { //135p
	private static final String DEPT_NS = "kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao";
	private static final String TITLE_NS = "kr.or.yi.gradle_mybatis_c3p0.dao.TitleDao";
	
	public void addTitleDepartment(Title title, Department department) {
		int res = 0;
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try {
			res+=sqlSession.insert(DEPT_NS + ".insertDepartment", department);
			res+=sqlSession.insert(TITLE_NS + ".insertTitle", title);
			
			if(res == 2) {
				sqlSession.commit();
			}else {
				throw new Exception();
			}
		}catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
		}
	}
	
	public int removeTitleDepartment(Title title, Department department) {
		int res = 0;
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try {
			res+=sqlSession.delete(DEPT_NS + ".deleteDepartment", department);
			res+=sqlSession.delete(TITLE_NS + ".deleteTitle", title);
			
			if(res == 2) {
				sqlSession.commit();
			}else {
				throw new Exception();
			}
		}catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
//			throw new RuntimeException(e.getCause()); 예외던지는거 말고 그냥 res를 리턴해서 test했을 때 res가 1이 찍히는걸 확인해보려고 함
		}finally {
			sqlSession.close();
		}
		return res;
	}
}
