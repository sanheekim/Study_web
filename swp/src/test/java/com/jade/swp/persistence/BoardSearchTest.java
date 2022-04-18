package com.jade.swp.persistence;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jade.swp.domain.Board;
import com.jade.swp.domain.Criteria;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardSearchTest {
	
	@Inject
	private BoardDAO dao;

	@Test
	public void testListSearchCount() throws Exception {
		Criteria criteria = new Criteria();
		criteria.setSearchType("t");
		criteria.setKeyword("12");
		
		criteria.setPerPageNum(20);
		List<Board> list = dao.listCriteria(criteria);
		
		assertEquals(list.size(), dao.countPaging(criteria));
	}
	
	@Test
	public void sdfasf() throws Exception {
		String [] names = {"Tom", "JIMMY", "JOHIN"};
		String [] anotherNames = {"Tom", "JIMMY", "JOHIN"};
		assertArrayEquals(names, anotherNames);
		
		Criteria criteria = new Criteria();
		criteria.setSearchType("tc");
		
		assertEquals("tc", criteria.getSearchType());
		
		assertThat("TC가 맞나요??", criteria.getSearchType(), is("tc"));
		assertThat(criteria.getSearchType(), instanceOf(String.class) );
		
	}

}
