package com.jade.swp;

import static org.junit.Assert.assertNotEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourceTest {
	
	@Inject
	private DataSource ds;

	@Test
	public void test() throws SQLException {
		try (Connection conn = ds.getConnection()) {
			System.out.println(conn);
			assertNotEquals(0, getTotal(conn));
			
//			if (totalCount <= 0)
//				fail("Not exists record!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final String TOTSQL = "select count(*) as cnt from Test";
	private long getTotal(Connection conn) throws Exception {
		long result = 0;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(TOTSQL);
			if (rs.next())
				result = rs.getInt(1);
			
			System.out.println("total count is " + result);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

}
