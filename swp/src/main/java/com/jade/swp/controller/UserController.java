package com.jade.swp.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.jade.swp.auth.SNSLogin;
import com.jade.swp.auth.SnsValue;
import com.jade.swp.domain.User;
import com.jade.swp.dto.LoginDTO;
import com.jade.swp.interceptor.SessionNames;
import com.jade.swp.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
	@Inject
	private SnsValue naverSns;
	
	@Inject
	private SnsValue googleSns;
	
	@Inject
	private GoogleConnectionFactory googleConnectionFactory;
	
	@Inject
	private OAuth2Parameters googleOAuth2Parameters;
	
	@RequestMapping(value = "/auth/{snsService}/callback", 
			method = { RequestMethod.GET, RequestMethod.POST})
	public String snsLoginCallback(@PathVariable String snsService,
			Model model, @RequestParam String code, HttpSession session) throws Exception {
		
		logger.info("snsLoginCallback: service={}", snsService);
		SnsValue sns = null;
		if (StringUtils.equals("naver", snsService))
			sns = naverSns;
		else
			sns = googleSns;
		
		// 1. code를 이용해서 access_token 받기
		// 2. access_token을 이용해서 사용자 profile 정보 가져오기
		SNSLogin snsLogin = new SNSLogin(sns);
		
		User snsUser = snsLogin.getUserProfile(code); // 1,2번 동시
		System.out.println("Profile>>" + snsUser);
		
		// 3. DB 해당 유저가 존재하는 체크 (googleid, naverid 컬럼 추가)
		User user = service.getBySns(snsUser);
		if (user == null) {
			model.addAttribute("result", "존재하지 않는 사용자입니다. 가입해 주세요.");
			
			//미존재시 가입페이지로!!
			
		} else {
			model.addAttribute("result", user.getUname() + "님 반갑습니다.");
			
			// 4. 존재시 강제로그인
			session.setAttribute(SessionNames.LOGIN, user);
		}
		
		
		return "loginResult";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("logout GET .....");
		logger.debug("TTTTTTTTTTT My Own Code");
		logger.info("Master Edited!!");
		session.removeAttribute(SessionNames.LOGIN);
		session.invalidate();
		
		Cookie loginCookie = WebUtils.getCookie(request, SessionNames.LOGIN);
		if (loginCookie != null) {
			loginCookie.setPath("/");
			loginCookie.setMaxAge(0);
			
			response.addCookie(loginCookie);
			
			User user = (User)session.getAttribute(SessionNames.LOGIN);
			service.keepLogin(user.getUid(), session.getId(), new Date());
		}
		
		return "/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(Model model) throws Exception {
		logger.info("login GET .....");
		
		SNSLogin snsLogin = new SNSLogin(naverSns);
		model.addAttribute("naver_url", snsLogin.getNaverAuthURL());
		
//		SNSLogin googleLogin = new SNSLogin(googleSns);
//		model.addAttribute("google_url", googleLogin.getNaverAuthURL());
		
		/* 구글code 발행을 위한 URL 생성 */
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		model.addAttribute("google_url", url);
	}
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPost(LoginDTO dto, Model model, HttpSession session) throws Exception {
		logger.info("loginPost...LoginDTO={}", dto); 
		
		try {
			User user = service.login(dto);
			if (user != null) {
				Date expire = new Date(System.currentTimeMillis() + SessionNames.EXPIRE * 1000);
				service.keepLogin(user.getUid(), session.getId(), expire);
				model.addAttribute("user", user);
				
			} else {
				model.addAttribute("loginResult", "Login Fail!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/logoutAjax", method=RequestMethod.GET)
	public ResponseEntity<String> logoutAjax(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session) {
		logger.info("Logout Ajax>> " + session.getAttribute("loginUser"));
		session.removeAttribute("loginUser");
		
		User user = (User)session.getAttribute(SessionNames.LOGIN);
		if (user != null) {
			session.removeAttribute(SessionNames.LOGIN);
			session.invalidate();
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if (loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
			}
		}
		
		return new ResponseEntity<>("logouted", HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/loginAjax", method = RequestMethod.POST)
	public ResponseEntity<User> loginAjax(@RequestBody LoginDTO dto, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("loginPost...LoginDTO={}", dto); 
		
		try {
			User user = service.login(dto);
			if (user != null) { // login success
				user.setUpw(null);
				
				session.setAttribute("loginUser", user);
				
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(7 * 24 * 60 * 60);
				
				response.addCookie(loginCookie);
				
				return new ResponseEntity<>(user, HttpStatus.OK);
				
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
}
