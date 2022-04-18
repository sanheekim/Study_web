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
public class MessageServiceTest {
	
	@Inject
	private MessageService service;
	
	private static Logger logger = LoggerFactory.getLogger(MessageServiceTest.class);
	
	@Test
	public void testReadMessage() throws Exception {
		service.readMessage("user2", 38);
	}

	@Test
	public void testWriteMessage() throws Exception {
		Message msg = new Message();
		msg.setSender("user1");
		msg.setTargetid("user2");
		msg.setMessage("Message 내용");
		logger.info("MESSAGE>>" + msg);
		service.addMessage(msg);
//		assertEquals("새글제목", board.getTitle());
	}

}
