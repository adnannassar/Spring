package com.adnan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("com.adnan.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersAndSetters()")
	public void beforeApiAnalytics() {
		System.out.println("======>>> Performing API analytics");
	}
}
