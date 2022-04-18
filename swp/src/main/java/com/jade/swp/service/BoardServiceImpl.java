package com.jade.swp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.jade.mapper.SampleMapper;
import com.jade.swp.domain.Board;
import com.jade.swp.domain.Criteria;
import com.jade.swp.domain.User;
import com.jade.swp.persistence.BoardDAO;
import com.jade.swp.persistence.ReplyDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Inject
	private ReplyDAO replyDao;
	
	@Inject
	private SampleMapper sampleMapper;

	@Transactional
	@Override
	public void regist(Board board) throws Exception {
		dao.create(board);
		
		String[] files = board.getFiles();
		if (files == null) return;
		
		for (String file: files) {
			dao.addAttach(file);
		}
	}

	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public Board read(Integer bno) throws Exception {
		dao.plusViewcount(bno);
		return dao.read(bno);
	}

	@Override
	public void modify(Board board) throws Exception {
		dao.update(board);
	}

	@Transactional
	@Override
	public void remove(Integer bno) throws Exception {
		dao.deleteAllAttaches(bno);
		replyDao.deleteAll(bno);
		dao.delete(bno);
	}

	@Override
	public List<Board> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public void dummy10() throws Exception {
		Integer maxbno = dao.getMaxbno();
		for (int i = maxbno + 1; i <= maxbno + 10; i++) {
			Board board = new Board("title" + i, "content" + i, "writer" + i);
			dao.create(board);
		}
	}

	@Override
	public List<Board> listCriteria(Criteria criteria) throws Exception {
		return dao.listCriteria(criteria);
	}

	@Override
	public int countPaging(Criteria criteria) {
		return dao.countPaging(criteria);
	}

	@Override
	public List<String> getAttach(Integer bno) {
		return dao.getAttach(bno);
	}

	@Override
	public void removeAttach(String fileName) {
		dao.deleteAttach(fileName);
	}

	@Transactional
	@Override
	public void appendAttach(String[] fullNames, Integer bno) {
		for (String fullName : fullNames)
			dao.appendAttach(fullName, bno);
	}

	@Override
	public String getTime() throws Exception {
		return sampleMapper.getTime();
	}

	@Override
	public String getUname(String uid) throws Exception {
		return sampleMapper.getUname(uid);
	}

	@Override
	public User getLoginInfo(String uid) throws Exception {
		return sampleMapper.getLoginInfo(uid);
	}

}
