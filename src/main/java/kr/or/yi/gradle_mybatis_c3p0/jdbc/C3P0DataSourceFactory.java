package kr.or.yi.gradle_mybatis_c3p0.jdbc;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0DataSourceFactory implements DataSourceFactory {
	private ComboPooledDataSource dataSource; //null할필요없음. 기본적으로 null로 초기화되있으니까
	
	@Override
	public void setProperties(Properties props) {
								//application.properties에 있는 정보를 담아서 가져온다
		dataSource = new ComboPooledDataSource();
		dataSource.setPassword(props.getProperty("password"));
		dataSource.setJdbcUrl(props.getProperty("url"));
		dataSource.setUser(props.getProperty("username"));
		try {
			dataSource.setDriverClass(props.getProperty("driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

}
