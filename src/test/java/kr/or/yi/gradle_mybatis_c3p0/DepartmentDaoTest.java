package kr.or.yi.gradle_mybatis_c3p0;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest extends AbstractTest {
	private static DepartmentDao deptDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		deptDao = new DepartmentDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		deptDao = null;
	}

	@Test
	public void test02SelectDepartmentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		List<Department> deptList = deptDao.selectDepartmentByAll();
		Assert.assertNotNull(deptList);
		
		for(Department d : deptList) {
			log.debug(String.format("%d -> %s", d.getDeptCode(), d.getDeptName()));
		}
	}
	
	@Test
	public void test01InsertDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Department insertDept = new Department(5, "마케팅", 10);
		int res = deptDao.insertDepartment(insertDept);
		
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test04DeleteDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Department deleteDept = new Department(5);
		int res = deptDao.deleteDepartment(deleteDept);
		
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test03UpdateDepartment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Department updateDept = new Department(5, "마케팅2", 12);
		int res = deptDao.updateDepartment(updateDept);
		
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test05SelectDepartmentByCode() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Department selectedDept = new Department(1);
		Department searchDept = deptDao.selectDepartmentByCode(selectedDept);
		
		log.debug("selectDept: " + searchDept);
		Assert.assertNotNull(searchDept);
	}
}
