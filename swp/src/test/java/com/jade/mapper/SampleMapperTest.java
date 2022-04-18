package com.jade.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jade.swp.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class SampleMapperTest {
	
	@Inject
	private SampleMapper sampleMapper;

	@Ignore @Test
	public void testGetTime() throws Exception {
		String className = sampleMapper.getClass().getName();
		System.out.println("className=" + className);
		String now = sampleMapper.getTime();
		System.out.println("now=" + now);
		assertTrue(StringUtils.startsWith(className, "com.sun.proxy."));
	}
	
	@Ignore @Test
	public void testGetLoginInfo() throws Exception {
		User user = sampleMapper.getLoginInfo("user1");
		System.out.println("UUUser>>" + user);
	}
	
	@Test
	public void testSearch() throws Exception {
		String searchCol = "uid";
		String searchStr = "user1";
		
		List<User> users = sampleMapper.searchUser(searchCol, searchStr);
		assertEquals(1, users.size());
		assertEquals(searchStr, users.get(0).getUid());
		System.out.println("UUUser>>" + users);
		
		searchCol = "uname";
		searchStr = "김";
		
		users = sampleMapper.searchUser(searchCol, searchStr);
		assertTrue(users.size() > 1);
		System.out.println("UUUser>>" + users);
		
		
	}

}
