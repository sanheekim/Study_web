package com.jade.swp.service;

import java.util.List;

import com.jade.swp.domain.Board;
import com.jade.swp.domain.Criteria;
import com.jade.swp.domain.User;

public interface BoardService {
	void regist(Board board) throws Exception;

	Board read(Integer bno) throws Exception;

	void modify(Board board) throws Exception;

	void remove(Integer bno) throws Exception;

	List<Board> listAll() throws Exception;
	
	List<Board> listCriteria(Criteria criteria) throws Exception;

	void dummy10() throws Exception;

	int countPaging(Criteria criteria);

	List<String> getAttach(Integer bno);

	void removeAttach(String fileName);

	void appendAttach(String[] fullNames, Integer bno);

	String getTime() throws Exception;

	String getUname(String uid) throws Exception;

	User getLoginInfo(String uid) throws Exception;
}
