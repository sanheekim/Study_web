package com.jade.swp.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.jade.swp.domain.User;
import com.jade.swp.service.UserService;

public class AuthInterceptor extends HandlerInterceptorAdapter implements SessionNames {
	
	@Inject
	private UserService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler)
			throws Exception {
		
		System.out.println("LoginInterceptor.pre>>");
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute(LOGIN) == null) {
			Cookie loginCookie = WebUtils.getCookie(request, SessionNames.LOGIN_COOKIE);
			if (loginCookie != null) {
				User loginedUser = service.checkLoginBefore(loginCookie.getValue());
				if (loginedUser != null) {
					session.setAttribute(LOGIN, loginedUser);
					return true;
				}
			}
			
			String uri = request.getRequestURI();
			String httpMethod = request.getMethod();
			if (StringUtils.contains(uri, "/replies/") 
					&& !StringUtils.equalsIgnoreCase(httpMethod, "GET")) {
				response.sendError(401, "Need Login");
				return false;
			}
			
			saveAttemptedLocation(request, session);
			
			response.sendRedirect("/login");
		}

		return true;
	}

	private void saveAttemptedLocation(HttpServletRequest request, HttpSession session) {
		String uri = request.getRequestURI(); //board/register
		String query = request.getQueryString(); //dfd=121
		if (StringUtils.isNotEmpty(query))
			uri += "?" + query;
		
		session.setAttribute(ATTEMPTED, uri);
	}
	
}