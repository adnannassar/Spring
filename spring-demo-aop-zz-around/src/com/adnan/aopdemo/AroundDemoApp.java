package com.adnan.aopdemo;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adnan.aopdemo.service.TrafficFortuneService;



public class AroundDemoApp {

	public static void main(String[] args) {
		// read spring config java class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the container 
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService" , TrafficFortuneService.class);
		System.out.println("Started");
		System.out.println(theFortuneService.getFortune());
		System.out.println("Finished");
		
		// close the context
		context.close();
	}

}
