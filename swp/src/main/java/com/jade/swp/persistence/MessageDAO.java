package com.jade.swp.persistence;

import com.jade.swp.domain.Message;

public interface MessageDAO {
	void create(Message message) throws Exception;
	Message readMessage(Integer mid) throws Exception;
	void updateState(Integer mid) throws Exception;
}
