package com.jade.swp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jade.swp.domain.Criteria;
import com.jade.swp.domain.Reply;
import com.jade.swp.persistence.BoardDAO;
import com.jade.swp.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO dao;
	
	@Inject
	private BoardDAO boardDao;

	@Override
	public List<Reply> listReply(Integer bno) throws Exception {
		return dao.list(bno);
	}

	@Transactional
	@Override
	public void addReply(Reply reply) throws Exception {
		dao.create(reply);
		boardDao.updateReplycnt(reply.getBno(), 1);
	}

	@Override
	public void modifyReply(Reply reply) throws Exception {
		dao.update(reply);
	}

	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {
		boardDao.updateReplycnt(dao.getBno(rno), -1);
		dao.delete(rno);
	}

	@Override
	public List<Reply> listReplyPage(Integer bno, Criteria criteria) throws Exception {
		return dao.listPage(bno, criteria);
	}

	@Override
	public int count(Integer bno) throws Exception {
		return dao.count(bno);
	}

	@Override
	public Reply readReply(Integer rno) {
		return dao.read(rno);
	}

}
