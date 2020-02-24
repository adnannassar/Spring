package com.adnan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advises for logging
	
	
	@Pointcut("execution(* com.adnan.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// lets's start with an @Before advice
	@Before("forDaoPackage()")
	public void beforeAddAcountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()")
	public void beforeApiAnalytics() {
		System.out.println("======>>> Performing API analytics");
	}
	

	
}
