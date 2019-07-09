package kr.or.yi.gradle_mybatis_c3p0;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.gradle_mybatis_c3p0.jdbc.MybatisSqlSessionFactory;

public class MybatisSqlSessionFactoryTest {
	private static final Log log = LogFactory.getLog(MybatisSqlSessionFactoryTest.class);
	
	@Test
	public void testOpenSession() {
		log.debug("testOpenSession");
		SqlSession session = MybatisSqlSessionFactory.openSession(); //제대로 db연결됐으면 null이 아니다
		log.debug("session " + session);
		
		Assert.assertNotNull(session);
	}

}
