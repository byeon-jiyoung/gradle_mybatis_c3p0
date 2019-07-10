package kr.or.yi.gradle_mybatis_c3p0;

import static org.junit.Assert.fail;

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
	public void test01SelectTitleByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
										//getStackTrace는 배열리턴
		List<Title> titleList = titleDao.selectTitleByAll();
		Assert.assertNotNull(titleList);
		
		for(Title t : titleList) {
			//log.debug(t.toString());
			log.debug(String.format("%d -> %s", t.getTitleNo(), t.getTitleName()));
		}
	}

}
