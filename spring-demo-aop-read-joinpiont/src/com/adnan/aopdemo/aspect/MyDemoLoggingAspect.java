package com.adnan.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	@Before("com.adnan.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersAndSetters()")
	public void beforeAddAcountAdvice(JoinPoint theJoinpoint) {
		System.out.println("======>>> Executing @Joinpoint advice on method");
		// display the method signature
		System.out.println("\t  The methode signature : " + theJoinpoint.getSignature());
		// display the method arguments
		if (theJoinpoint.getArgs().length !=0 ) {
			for (Object c : theJoinpoint.getArgs()) {
				if (c != null) {
					System.out.println("\t  The arugmets : " + c);
				}
			}
		}else {
			System.out.println("\t  The mothod has no arguments!!");
		}
	}

}
