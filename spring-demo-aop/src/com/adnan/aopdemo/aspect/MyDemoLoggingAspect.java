package com.adnan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advises for logging
	
	
	// lets's start with an @Before advice
	@Before("execution(public void addAccount())")
	public void beforeAddAcountAdvice() {
		System.out.println("\n======> Executing @Before advice on addAccount()");
	}
}
