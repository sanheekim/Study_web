package com.jade.swp.service;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jade.swp.domain.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class AaaTest {
	@Inject
	private MessageService service;
	
	private static Logger logger = LoggerFactory.getLogger(AaaTest.class);

	@Test
	public void testRead() throws Exception {
		Message msg = service.readMessage("user2", 2);
		logger.info(msg.toString());
		assertEquals("user1",msg.getSender());
	}
	
}
