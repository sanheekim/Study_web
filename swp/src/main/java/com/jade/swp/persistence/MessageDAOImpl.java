package com.jade.swp.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jade.swp.domain.Message;

@Repository
public class MessageDAOImpl implements MessageDAO {
	@Inject
	private SqlSession session;
	
	private static final String NS = "com.jade.swp.persistence.MessageMapper";
	private static final String CREATE = NS + ".create";
	private static final String READ_MESSAGE = NS + ".read";
	private static final String UPDATE_STATE = NS + ".updateState";

	@Override
	public void create(Message message) throws Exception {
		session.insert(CREATE, message);
	}

	@Override
	public Message readMessage(Integer mid) throws Exception {
		return session.selectOne(READ_MESSAGE, mid);
	}

	@Override
	public void updateState(Integer mid) throws Exception {
		session.update(UPDATE_STATE, mid);
	}

}
