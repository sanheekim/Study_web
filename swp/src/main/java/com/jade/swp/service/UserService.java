package com.jade.swp.service;

import java.util.Date;

import com.jade.swp.domain.User;
import com.jade.swp.dto.LoginDTO;

public interface UserService {

	User login(LoginDTO dto) throws Exception;

	void keepLogin(String uid, String id, Date expire);

	User checkLoginBefore(String value);

	User getBySns(User snsUser);
	
}
