package jarTool.springjdbc;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSON;


/**
 * @Description : 连接db查出数据
 * @Date: 2018年1月26日 上午1:48:14
 */
public class TestJdbc2Mysql {
	
	private static JdbcTemplate jdbcTemplate = TestJdbcConnectFactory.getInstance();
	
	public static void main(String[] args) {
		System.out.println("++");
		
		String query ="select * from test.user limit 10 ";
		List<Map<String,Object>> results = jdbcTemplate.queryForList(query);
		System.out.println("results= " + JSON.toJSONString(results));
		System.out.println("+ - +");
		
		/*
		 *打印结果：
++
Fri Jan 26 01:44:46 CST 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
01:44:46.463 [main] INFO com.alibaba.druid.pool.DruidDataSource - {dataSource-1} inited
results= [{"id":1,"name":"a","age":11},{"id":2,"name":"b","age":22},{"id":3,"name":"c","age":33}]
+ - +
		 */
	}
	
	@Test
	public void testJdbcQuery(){
		
		String query ="select * from test.user limit 10 ";
		List<Map<String,Object>> results = jdbcTemplate.queryForList(query);
		System.out.println("results= " + JSON.toJSONString(results));
	}
	
	
}
