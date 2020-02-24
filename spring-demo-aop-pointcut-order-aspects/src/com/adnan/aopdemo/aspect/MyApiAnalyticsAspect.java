package com.adnan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyApiAnalyticsAspect {

	
	
	

	@Before("forDaoPackageNoGettersAndSetters()")
	public void beforeApiAnalytics() {
		System.out.println("======>>> Performing API analytics");
	}
}
