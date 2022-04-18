package com.jade.swp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jade.swp.domain.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardServiceTest {
	
	@Inject
	private BoardService service;
	
	private static Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);

	@Ignore @Test
	public void testRead() throws Exception {
		Board board = service.read(2);
		logger.debug(board.toString());
		assertEquals("새글제목", board.getTitle());
	}
	
	@Test
	public void testRegist() throws Exception {
		Board board = new Board();
		board.setTitle("Test제목");
		board.setContent("Test 내용");
		board.setWriter("홍길동");
		
		assertNull(board.getFiles());
		
		service.regist(board);
		
		logger.info("testRegist.board={}", board.toString());
	}

}
