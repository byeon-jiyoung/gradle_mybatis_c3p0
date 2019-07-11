package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	int insertDepartment(Department department);
	int deleteDepartment(Department department);
	int updateDepartment(Department department);
	Department selectDepartmentByCode(Department department);
}
