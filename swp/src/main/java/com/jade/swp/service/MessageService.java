package com.jade.swp.service;

import com.jade.swp.domain.Message;

public interface MessageService {
	void addMessage(Message message) throws Exception;
	Message readMessage(String uid, Integer mid) throws Exception;
	void ttt();
}
