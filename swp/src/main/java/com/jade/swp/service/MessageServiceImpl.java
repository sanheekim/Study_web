package com.jade.swp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jade.swp.domain.Message;
import com.jade.swp.persistence.MessageDAO;
import com.jade.swp.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService {
	@Inject
	MessageDAO messageDao;
	
	@Inject
	PointDAO pointDao;
	
	private static final int WRITE_POINT = 10;
	private static final int READ_POINT = 5;

	@Transactional
	@Override
	public void addMessage(Message message) throws Exception {
		messageDao.create(message);
		pointDao.updatePoint(message.getSender(), WRITE_POINT);
	}

	@Transactional
	@Override
	public Message readMessage(String uid, Integer mid) throws Exception {
		messageDao.updateState(mid);
		pointDao.updatePoint(uid, READ_POINT);
		return messageDao.readMessage(mid);
	}

	@Override
	public void ttt() {
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
	}

}
