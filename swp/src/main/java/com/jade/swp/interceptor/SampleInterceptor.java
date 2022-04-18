package com.jade.swp.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jade.swp.domain.Board;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler)
			throws Exception {
		
		System.out.println("prereeeeeeeeeeeeee: " + request.getRequestURI());
		System.out.println("prereeeeeeeeeeeeee: " + handler);

		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, 
			Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("afterrrrrrrrrrrrrrrr");
		@SuppressWarnings("rawtypes")
		List<Board> list = (List)modelAndView.getModel().get("list");
		System.out.println("list.size=" + list.size());
	}
}
