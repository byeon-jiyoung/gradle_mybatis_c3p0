package kr.or.yi.gradle_mybatis_c3p0;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest extends AbstractTest {
	private static TitleDao titleDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		titleDao = new TitleDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		titleDao = null;
	}

	@Test
	public void test02SelectTitleByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()"); //수행한 메소드 이름만 추출한다. 그냥 확인용으로 넣은거라 필요없으면 안해도됨
										//getStackTrace는 배열리턴
		//= log.debug("test02SelectTitleByAll()"); 이거랑 같은 의미
		
		List<Title> titleList = titleDao.selectTitleByAll();
		Assert.assertNotNull(titleList);
		
		for(Title t : titleList) {
			//log.debug(t.toString());
			log.debug(String.format("%d -> %s", t.getTitleCode(), t.getTitleName()));
		}
	}
	
	@Test
	public void test01InsertTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Title insertTitle = new Title(6, "인턴");
		int res = titleDao.insertTitle(insertTitle);
		
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test03UpdateTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Title updateTitle = new Title(6, "계약직");
		
		int res = titleDao.updateTitle(updateTitle);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test04DeleteTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Title deleteTitle = new Title(6);
		
		int res = titleDao.deleteTitle(deleteTitle);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test05SelectTitleByCode() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Title selectedTitle = new Title(1);
		
		Title searchTitle = titleDao.selectTitleByCode(selectedTitle);
		
		log.debug("selectTitle : " + searchTitle);
		Assert.assertNotNull(searchTitle);
	}
}
