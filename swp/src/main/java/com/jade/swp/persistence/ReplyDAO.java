package com.jade.swp.persistence;

import java.util.List;

import com.jade.swp.domain.Criteria;
import com.jade.swp.domain.Reply;

public interface ReplyDAO {
	List<Reply> list(Integer bno) throws Exception;

	void create(Reply reply) throws Exception;

	void update(Reply reply) throws Exception;

	void delete(Integer rno) throws Exception;
	
	void deleteAll(Integer bno) throws Exception;

	List<Reply> listPage(Integer bno, Criteria criteria) throws Exception;

	int count(Integer bno) throws Exception;

	Reply read(Integer rno);
	
	int getBno(Integer rno) throws Exception;
}
