package com.jade.swp.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jade.swp.domain.Criteria;
import com.jade.swp.domain.Reply;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String NS = "com.jade.swp.persistence.ReplyMapper";
	private static final String LIST = NS + ".list";
	private static final String READ = NS + ".read";
	private static final String CREATE = NS + ".create";
	private static final String UPDATE = NS + ".update";
	private static final String DELETE = NS + ".delete";
	private static final String DELETE_ALL = NS + ".deleteAll";
	private static final String LIST_PAGE = NS + ".listPage";
	private static final String COUNT = NS + ".count";
	private static final String GET_BNO = NS + ".getBno";

	@Override
	public List<Reply> list(Integer bno) throws Exception {
		return session.selectList(LIST, bno);
	}

	@Override
	public void create(Reply reply) throws Exception {
		session.insert(CREATE, reply);
	}

	@Override
	public void update(Reply reply) throws Exception {
		session.update(UPDATE, reply);
	}

	@Override
	public void delete(Integer rno) throws Exception {
		session.delete(DELETE, rno);
	}

	@Override
	public List<Reply> listPage(Integer bno, Criteria criteria) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("criteria", criteria);
		return session.selectList(LIST_PAGE, paramMap);
	}

	@Override
	public int count(Integer bno) throws Exception {
		return session.selectOne(COUNT, bno);
	}

	@Override
	public Reply read(Integer rno) {
		return session.selectOne(READ, rno);
	}

	@Override
	public int getBno(Integer rno) throws Exception {
		return session.selectOne(GET_BNO, rno);
	}

	@Override
	public void deleteAll(Integer bno) throws Exception {
		session.delete(DELETE_ALL, bno);
	}

}
