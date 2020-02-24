package com.adnan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	@Before("com.adnan.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersAndSetters()")
	public void beforeAddAcountAdvice() {
		System.out.println("======>>> Executing @Before advice on method");
	}

}
