package kr.or.yi.gradle_mybatis_c3p0;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_c3p0.dao.EmployeeDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.EmployeeDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.dto.State;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest extends AbstractTest {
	private static EmployeeDao empDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empDao = new EmployeeDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empDao = null;
	}

	@Test
	public void test01SelectEmployeeByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		List<Employee> empList = empDao.selectEmployeeByAll();
		Assert.assertNotNull(empList);
		
		for(Employee e : empList) {
			log.debug(e.toString());
		}
	}
	
	@Test
	public void test03UpdateEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Calendar joinDate = Calendar.getInstance();
		joinDate.clear();
		joinDate.set(Calendar.YEAR, 2018);
		joinDate.set(Calendar.MONTH, 7);
		joinDate.set(Calendar.DAY_OF_MONTH, 01);
		
		Employee upEmp = new Employee(5000, "김우빈", 5000000, new Department(1), true, joinDate.getTime(), new Title(2));
		
		int res = empDao.updateEmployee(upEmp);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test02InsertEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Date joinDate = new Date();
		Employee newEmp = new Employee(5000, "김우빈", 5500000, new Department(2), true, joinDate, new Title(3));
		int res = empDao.insertEmployee(newEmp);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test04SelectByCodeEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Employee selEmp = new Employee(1003, "조민희");
		
		Employee emp = empDao.selectEmployeeByCode(selEmp);
		Assert.assertNotNull(emp);
	}
	
	@Test
	public void test05DeleteEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Employee delEmp = new Employee(5000, "김우빈");
		
		int res = empDao.deleteEmployee(delEmp);
		Assert.assertEquals(1, res);
	}
	
	//149p
	@Test
	public void test06GetSalaryByDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("deptno", 1); //deptno에 1을 넣는다
					//impl에 넣은 변수명과 동일해야 한다
		log.debug(param.get("deptno")+"");
		
		Map<String , Object> result = empDao.getSalaryByDepartment(param);
		
		for(Entry<String, Object> e : result.entrySet()) {
			log.debug(String.format("%s -> %d", e.getKey(), e.getValue()));
		}
		Assert.assertNotEquals(0, result.size());
	}
	
	@Test
	public void test07GetStateSalaryByDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Map<String, Object> param = new HashMap<>();
		param.put("deptno", 2);
		
		State state = empDao.getStateSalaryByDepartment(param);
		log.debug(state.toString());
		
		Assert.assertNotEquals(null, state);
	}
}
