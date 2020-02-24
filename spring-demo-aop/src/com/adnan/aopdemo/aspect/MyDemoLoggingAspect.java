package com.adnan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advises for logging
	
	
	// lets's start with an @Before advice
	@Before("execution(public void com.adnan.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAcountAdvice() {
		System.out.println("\n======> Executing @Before advice on addAccount()");
	}
	

	@Before("execution(public int summe(java.lang.Integer,..))")
	public void beforeSumme() {
		System.out.println("\n======> Executing @Before advice on summe(java.lang.Integer)");
	}
	
	
	@Before("execution(* add*(com.adnan.aopdemo.Account))")
	public void beforeSummeAnyType() {
		System.out.println("\n======> Executing @Before advice on add(Account)");
	}

	// this means match with all methods in the package
	// @Before("execution(* com.adnan.aopdemo.*.*(..))")

	
}
