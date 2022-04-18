package com.jade.swp.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jade.swp.domain.Board;
import com.jade.swp.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;

	private static final String NS = "com.jade.swp.persistence.BoardMapper";
	private static final String CREATE = NS + ".create";
	private static final String READ = NS + ".read";
	private static final String UPDATE = NS + ".update";
	private static final String DELETE = NS + ".delete";
	private static final String SELECT_ALL = NS + ".listAll";
	private static final String SELECT_PAGE = NS + ".listPage";
	private static final String SELECT_CRITERIA = NS + ".listCriteria";
	private static final String GetMaxbno = NS + ".getMaxbno";
	private static final String COUNT_PAGING = NS + ".countPaging";
	private static final String UPDATE_REPLYCNT = NS + ".updateReplycnt";
	private static final String PLUS_VIEWCNT = NS + ".plusViewcnt";
	private static final String ADD_ATTACH = NS + ".addAttach";
	private static final String GET_ATTACH = NS + ".getAttach";
	private static final String DEL_ATTACH = NS + ".delAttach";
	private static final String APPEND_ATTACH = NS + ".appendAttach";
	private static final String DELETE_ALL_ATTACHES = NS + ".deleteAllAttaches";

	@Override
	public void create(Board board) throws Exception {
		session.insert(CREATE, board);
	}

	@Override
	public Board read(Integer bno) throws Exception {
		return session.selectOne(READ, bno);
	}

	@Override
	public void update(Board board) throws Exception {
		session.update(UPDATE, board);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(DELETE, bno);
	}

	@Override
	public List<Board> listAll() throws Exception {
		return session.selectList(SELECT_ALL);
	}

	@Override
	public Integer getMaxbno() throws Exception {
		return session.selectOne(GetMaxbno);
	}

	@Override
	public List<Board> listPage(int page) throws Exception {
		if (page <= 0)
			page = 1;
		
		page = (page - 1) * 10;
		return session.selectList(SELECT_PAGE, page);
	}

	@Override
	public List<Board> listCriteria(Criteria criteria) throws Exception {
		return session.selectList(SELECT_CRITERIA, criteria);
	}

	@Override
	public int countPaging(Criteria criteria) {
		return session.selectOne(COUNT_PAGING, criteria);
	}

	@Override
	public void updateReplycnt(Integer bno, int amt) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("amt", amt);
		session.update(UPDATE_REPLYCNT, paramMap);
	}

	@Override
	public void plusViewcount(Integer bno) {
		session.update(PLUS_VIEWCNT, bno);
	}

	@Override
	public void addAttach(String file) {
		session.insert(ADD_ATTACH, file);
	}

	@Override
	public List<String> getAttach(Integer bno) {
		return session.selectList(GET_ATTACH, bno);
	}

	@Override
	public void deleteAttach(String fileName) {
		session.delete(DEL_ATTACH, fileName);
	}

	@Override
	public void appendAttach(String fullName, Integer bno) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("fullname", fullName);
		System.out.println("fullName>>>>>>>>>>" + fullName);
		session.insert(APPEND_ATTACH, paramMap);
	}

	@Override
	public void deleteAllAttaches(Integer bno) {
		session.delete(DELETE_ALL_ATTACHES, bno);
	}

}
