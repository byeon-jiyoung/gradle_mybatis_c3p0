package kr.or.yi.gradle_mybatis_c3p0.service;

import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.gradle_mybatis_c3p0.AbstractTest;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

public class TransactionServiceTest extends AbstractTest { //137p
	private static TransactionService service = new TransactionService();

	@Test(expected = RuntimeException.class)
	public void test01Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Title title = new Title();
		title.setTitleCode(1);
		title.setTitleName("사원");
		
		Department dept = new Department(6, "H/W개발", 6);
		service.addTitleDepartment(title, dept);
	}
	
	@Test(expected = RuntimeException.class)
	public void test02Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Title title = new Title();
		title.setTitleCode(7);
		title.setTitleName("무기계약");
		
		Department dept = new Department(1, "개발", 6);
		service.addTitleDepartment(title, dept);
	}
	
	@Test
	public void test03Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Title title = new Title();
		title.setTitleCode(7);
		title.setTitleName("무기계약");
		
		Department dept = new Department(6, "H/W개발", 6);
		service.addTitleDepartment(title, dept);
	}
	
	@Test(expected = RuntimeException.class)
	public void test04Delete() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Title title = new Title();
		title.setTitleCode(8);
		title.setTitleName("사원");
		
		Department dept = new Department(6, "H/W개발", 6);
		int res = service.removeTitleDepartment(title, dept);
		
		Assert.assertEquals(1, res);
		log.debug("res = " + res);
	}
	
	@Test(expected = RuntimeException.class)
	public void test05Delete() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Title title = new Title();
		title.setTitleCode(7);
		title.setTitleName("무기계약");
		
		Department dept = new Department(10, "개발", 6);
		int res = service.removeTitleDepartment(title, dept);
		
		Assert.assertEquals(1, res);
		log.debug("res = " + res);
	}
	
	@Test
	public void test06Delete() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Title title = new Title();
		title.setTitleCode(7);
		title.setTitleName("무기계약");
		
		Department dept = new Department(6, "H/W개발", 6);
		int res = service.removeTitleDepartment(title, dept);
		
		Assert.assertEquals(1, res);
		log.debug("res = " + res);
	}
}
