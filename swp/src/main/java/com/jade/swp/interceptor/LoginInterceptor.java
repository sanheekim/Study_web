package com.jade.swp.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jade.mapper.SampleMapper;
import com.jade.swp.domain.User;

public class LoginInterceptor extends HandlerInterceptorAdapter implements SessionNames {
	
	@Inject
	private SampleMapper mapper;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler)
			throws Exception {
		
		System.out.println("LoginInterceptor.pre>>");
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute(LOGIN) != null) {
			session.removeAttribute(LOGIN);
		}

		return true;
	}

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, 
			Object handler, ModelAndView modelAndView) throws Exception {
		
		HandlerMethod method = (HandlerMethod) handler;
		System.out.println("MMMM>> Bean: " + method.getBean() + ", Method: " + method.getMethod());
		System.out.println("MMMM>> Model: " + modelAndView);
		
		HttpSession session = request.getSession();
		
		User user = (User)modelAndView.getModelMap().get("user");
		System.out.println("LoginInterceptor.post>>" + user);
		
		if (user != null) {
			session.setAttribute(LOGIN, user);
			
			mapper.updateLogin(user.getUid(), request.getRemoteAddr());
			
			if (StringUtils.isNotEmpty(request.getParameter("useCookie"))) {
				Cookie loginCookie = new Cookie(LOGIN_COOKIE, session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(EXPIRE);
				
				response.addCookie(loginCookie);
			}
			
			String attempted = (String)session.getAttribute(ATTEMPTED);
			if (StringUtils.isNotEmpty(attempted)) {
				response.sendRedirect(attempted);
				session.removeAttribute(ATTEMPTED);
			
			} else {
				response.sendRedirect("/board/listPage");
			}
			
		}
	}
}
