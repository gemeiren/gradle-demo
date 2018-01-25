package jarTool.springjdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @Description : 连接db
 * @Date: 2018年1月26日 上午1:47:59
 */
public class TestJdbcConnectFactory {
	
	
	//db resource file use getResourceAsStream			http://blog.csdn.net/bluishglc/article/details/38753047
	private static final String DB_CONNECT_FILE = "connect-test.properties";


	final static class JdbcConnectSingleton {
		private static JdbcTemplate instance = TestJdbcConnectFactory.createjdbcTemplate();
	}
	
	//singleton
	public static JdbcTemplate getInstance() {
		return JdbcConnectSingleton.instance;
	}
	
	private static JdbcTemplate createjdbcTemplate() {
		Properties p;
		try {
			p = getProperties();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		DataSource ds;
		try {
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			System.out.println("DruidDataSource error " + e.getMessage());
			throw new RuntimeException(e);
		}
		JdbcTemplate jt = new JdbcTemplate(ds);
		return jt;
	}
	
	// read the db resource
	private static Properties getProperties() throws IOException {
		InputStream is = TestJdbcConnectFactory.class.getResourceAsStream(DB_CONNECT_FILE);
		try {
			Properties p = new Properties();
			p.load(is);
			return p;
		} finally {
			is.close();
		}
	}
	
	

}
