package com.adnan.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.adnan.aopdemo.Account;


@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Before("com.adnan.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersAndSetters()")
	public void beforeAddAcountAdvice(JoinPoint theJoinpoint) {
		System.out.println("======>>> Executing @Before advice on method");
		// display the method signature
		System.out.println("\t  The methode signature : " + theJoinpoint.getSignature());
		// display the method arguments
		if (theJoinpoint.getArgs().length != 0) {
			for (Object c : theJoinpoint.getArgs()) {
				if (c != null) {
					System.out.println("\t  The arugmets : " + c);
				}
			}
		} else {
			System.out.println("\t  The mothod has no arguments!!");
		}
	}

	@AfterReturning(pointcut = "execution(* com.adnan.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		System.out.println("\n======>>> Executing @AfterReturning advice on method");
		// display the method signature
		System.out.println("\t  The methode signature : " + theJoinPoint.getSignature());
		// print out the results of the method call
		System.out.println("The list before manipulation it : \n" + result);
		// edit the data "Result"
		System.out.println("Injecting the new Account of Hacker...");
		result.add(new Account("HACKER", "200"));

	}

	@AfterThrowing(pointcut = "execution(* com.adnan.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theException")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theException) {
		System.out.println("\n======>>> Executing @AfterThrowing advice on method");
		// display the method signature
		System.out.println("\t  The methode signature : " + theJoinPoint.getSignature());

		// log the Exception
		System.out.println("\t  The Exception Message : " + theException.getMessage());
	}

	@After("execution(* com.adnan.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinpoint) {
		System.out.println("\n======>>> Executing @After advice on method");
		// display the method signature
		System.out.println("\t  The methode signature : " + theJoinpoint.getSignature());
		// display the method arguments
		if (theJoinpoint.getArgs().length != 0) {
			for (Object c : theJoinpoint.getArgs()) {
				if (c != null) {
					System.out.println("\t  The arugmets : " + c);
				}
			}
		} else {
			System.out.println("\t  The mothod has no arguments!!");
		}
	}

	@Around("execution(* com.adnan.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		System.out.println("\n======>>> Executing @Around advice on method");
		// display the method signature
		System.out.println("\t  The methode signature : " + theProceedingJoinPoint.getSignature());

		// get begin time stamp
		long begin = System.currentTimeMillis();
		// now, let's execute the method
		Object result = theProceedingJoinPoint.proceed();
		// get end time stamp
		long end = System.currentTimeMillis();
		// compute duration and display t
		long duration = end - begin;
		System.out.println("\n======> Duration : " + duration / 1000.0 + " seconds");
		
		// "result" here will be the String that the getFortune() returns
		return result;
	}
}
