package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
//	int insertEmployee(Employee employee);
//	int deleteDepartment(Employee employee);
//	int updateDepartment(Employee employee);
//	Department selectDepartmentByCode(Employee employee);
}