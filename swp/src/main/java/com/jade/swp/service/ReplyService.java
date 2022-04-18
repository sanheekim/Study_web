package com.jade.swp.service;

import java.util.List;

import com.jade.swp.domain.Criteria;
import com.jade.swp.domain.Reply;

public interface ReplyService {
	List<Reply> listReply(Integer bno) throws Exception;

	void addReply(Reply reply) throws Exception;

	void modifyReply(Reply reply) throws Exception;

	void removeReply(Integer rno) throws Exception;
	
	List<Reply> listReplyPage(Integer bno, Criteria criteria) throws Exception;
	
	int count(Integer bno) throws Exception;

	Reply readReply(Integer rno);
}
