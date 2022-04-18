package com.jade.swp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import com.jade.swp.domain.Criteria;
import com.jade.swp.domain.PageMaker;
import com.jade.swp.domain.Reply;
import com.jade.swp.domain.User;
import com.jade.swp.interceptor.SessionNames;
import com.jade.swp.service.ReplyService;

@RestController
@RequestMapping("/replies/*")
public class ReplyController {
	@Inject
	private ReplyService service;

	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody Reply reply, HttpServletRequest request, HttpSession session) {
		logger.debug("ReplyRegister>> {}", reply);
		
		User loginUser = (User)session.getAttribute(SessionNames.LOGIN);
		
		logger.info("ReplyController.POST={}", loginUser);
		try {
//			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
//			if (loginUser == null && loginCookie == null) {
//				return new ResponseEntity<>("Not LoggedIn", HttpStatus.UNAUTHORIZED);
//				
//			} else if (loginCookie != null) {
//				loginUser = new User();
//				loginUser.setUid("user1");
//			}
			
//			reply.setReplyer(loginUser.getUid());
			service.addReply(reply);
			return new ResponseEntity<>("success111", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<Reply>> list(@PathVariable Integer bno) {
		logger.debug("ReplyListAll bno>> {}", bno);
		try {
			List<Reply> list = service.listReply(bno);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{bno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(
			@PathVariable Integer bno, @PathVariable Integer page,
			HttpSession session) {
		logger.debug("ReplyListPage bno, page>> {}, {}", bno, page);
		Map<String, Object> resultMap = new HashMap<>();
		try {
			Criteria criteria = new Criteria(page);
			List<Reply> list = service.listReplyPage(bno, criteria);
			resultMap.put("list", list);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCriteria(criteria);
			pageMaker.setTotalCount(service.count(bno));
			resultMap.put("pageMaker", pageMaker);
			
			User loginUser = (User)session.getAttribute(SessionNames.LOGIN);
			if (loginUser != null)
				resultMap.put("loginUid", loginUser.getUid());
			
			return new ResponseEntity<>(resultMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{rno}", method = {RequestMethod.GET})
	public ResponseEntity<Reply> read(@PathVariable Integer rno) {
		logger.debug("ReplyREAD>> {}", rno);
		try {
			Reply reply = service.readReply(rno);
			return new ResponseEntity<>(reply, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{rno}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable Integer rno, @RequestBody Reply reply) {
		logger.debug("ReplyUpdate>> {}, {}", rno, reply);
		try {
			reply.setRno(rno);
			service.modifyReply(reply);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable Integer rno) {
		logger.debug("ReplyDelete bno>> {}", rno);
		try {
			service.removeReply(rno);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
