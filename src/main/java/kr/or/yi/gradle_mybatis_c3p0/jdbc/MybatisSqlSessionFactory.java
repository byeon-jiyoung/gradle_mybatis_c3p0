package kr.or.yi.gradle_mybatis_c3p0.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	
	private static SqlSessionFactory getSqlSessionFactory() {
		if(sqlSessionFactory == null) {
			try(InputStream is = Resources.getResourceAsStream("mybatis.xml")) {
																//이 설정파일을 읽어와서
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(is); //sqlSessionFactory을 만들어라
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getCause()); 
							//runtime이라서 함수명 옆에 굳이 throw안해줘도 에러안뜸
			}
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession() { //외부호출용
		return getSqlSessionFactory().openSession();
										//연결된 정보만 계속 읽어주는거지
	}
}
