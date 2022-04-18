package com.jade.swp.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAdvice {
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	
	@Before("execution(* com.jade.swp.service.MessageService*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("----------------------- startLog ---------");
		logger.info(" pointcut >> " + jp.getSignature().getName());
		logger.info(" args >> " + Arrays.toString(jp.getArgs()));
	}
	
	@After("execution(* com.jade.swp.service.MessageService*.*(..))")
	public void endLog(JoinPoint jp) {
		logger.info("----------------------- endLog ---------");
		logger.info(" pointcut >> " + jp.getSignature().getName());
		logger.info(" args >> " + Arrays.toString(jp.getArgs()));
	}
	
	@Around("execution(* com.jade.swp.service.MessageServiceImpl.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("---------------------------------------- timeLog");
		
		long stime = System.currentTimeMillis();
		Object result = pjp.proceed();
		System.out.println(">> " + pjp.getSignature().getName() + "::" + (System.currentTimeMillis() - stime));
		logger.info("-------------------- timeLog --------");
		return result;
	}
}
