package com.jade.swp.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jade.swp.domain.Message;
import com.jade.swp.service.MessageService;

@RestController
@RequestMapping("/messages/*")
public class MessageController {
//	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Inject
	private MessageService service;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody Message message) {
		ResponseEntity<String> entity = null;
//		logger.info("addMessage = {}", message);
		try {
			service.addMessage(message);
			entity = new ResponseEntity<>("SUCCESS ADD MSG", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/{uid}/{mid}", method = RequestMethod.GET)
	public ResponseEntity<Message> readMessage(
			@PathVariable String uid,
			@PathVariable Integer mid) {
//		logger.info("ReadMessage uid, mid>> {}, {}", uid, mid);
		service.ttt();
		try {
			Message message = service.readMessage(uid, mid);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/ttt", method = RequestMethod.GET)
	public void tttMessage() {
		service.ttt();
	}

}
