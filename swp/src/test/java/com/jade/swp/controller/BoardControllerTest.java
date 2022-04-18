package com.jade.swp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardControllerTest.class);

	@Inject
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.debug("setup BoardControllerTest mockMvc...");
	}

	@Ignore @Test
	public void testListPage() throws Exception {
		this.mockMvc.perform(get("/board/listPage").param("page", "2"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(handler().handlerType(BoardController.class))
		.andExpect(handler().methodName("listPage"));
	}
	
	@Ignore @Test
	public void testRead() throws Exception {
		this.mockMvc.perform(get("/board/read").param("bno", "2"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(handler().handlerType(BoardController.class))
		.andExpect(handler().methodName("read"));
	}
	
	@Ignore @Test
	public void testRead2() throws Exception {
		this.mockMvc.perform(get("/board/read").param("bno", "1"))
		.andDo(print())
		.andExpect(status().is4xxClientError())
		.andExpect(handler().handlerType(BoardController.class))
		.andExpect(handler().methodName("read"));
	}
	
	@Ignore @Test
	public void testUpdate() throws Exception {
		this.mockMvc.perform(post("/board/update")
				.param("bno", "255")
				.param("title", "new title")
				.param("content", "new content")
				)
		.andDo(print())
		.andExpect(status().is3xxRedirection())
		.andExpect(handler().handlerType(BoardController.class))
		.andExpect(handler().methodName("updatePost"));
	}

}
