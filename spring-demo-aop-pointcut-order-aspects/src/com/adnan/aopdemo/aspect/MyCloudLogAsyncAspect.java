package com.adnan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLogAsyncAspect {
		
	
	
	@Before("forDaoPackageNoGettersAndSetters()")
	public void logingToCloudAsync() {
		System.out.println("======>>> Loging to Cloud in Async fashoin");
	}
	
}
