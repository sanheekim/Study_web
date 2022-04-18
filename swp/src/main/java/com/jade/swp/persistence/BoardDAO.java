package com.jade.swp.persistence;

import java.util.List;

import com.jade.swp.domain.Board;
import com.jade.swp.domain.Criteria;

public interface BoardDAO {
	void create(Board board) throws Exception;

	Board read(Integer bno) throws Exception;

	void update(Board board) throws Exception;

	void delete(Integer bno) throws Exception;

	List<Board> listAll() throws Exception;

	List<Board> listPage(int page) throws Exception;

	List<Board> listCriteria(Criteria criteria) throws Exception;

	Integer getMaxbno() throws Exception;

	int countPaging(Criteria criteria);
	
	void updateReplycnt(Integer bno, int amt) throws Exception;

	void plusViewcount(Integer bno);

	void addAttach(String file);

	List<String> getAttach(Integer bno);

	void deleteAttach(String fileName);

	void appendAttach(String fullName, Integer bno);

	void deleteAllAttaches(Integer bno);
}
