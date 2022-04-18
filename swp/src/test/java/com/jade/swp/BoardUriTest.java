package com.jade.swp;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class BoardUriTest {
	private static Logger logger = LoggerFactory.getLogger(BoardUriTest.class);
	
	@Test
	public void testURI2() throws Exception {
		int bno = 207;
		int perPageNum = 20;
		UriComponents uriComponents = null;
		for (int i = 0; i < 20000; i++) {
			uriComponents = UriComponentsBuilder.newInstance()
					.path("/{module}/{page}")
					.queryParam("bno", bno)
					.queryParam("perPageNum", perPageNum)
					.queryParam("keyword", "강원도 고성군 토성면 케잌 뷐 김정수 홍길동!$&?ㅇㄴㅁㅇ")
					.build()
					.expand("board", "read")
					.encode();
		}
		
		String uri = "/board/read?bno=" + bno + "&perPageNum=" + perPageNum;
		logger.info(uri );
		logger.info(uriComponents.toString());
		
//		assertEquals(uri, uriComponents.toString());
	}
}