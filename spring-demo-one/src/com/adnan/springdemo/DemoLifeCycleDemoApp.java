package com.adnan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoLifeCycleDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLiveCycle-applicationContext.xml");

		// retrieve bean form the spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		

		
		System.out.println("Memory location for theCoach: " + theCoach);
		

		// call methods on the bean
		System.out.println("Beans: " + theCoach.getDailyWorkout());
		System.out.println("Injection: " + theCoach.getDailyFortune());

		// close the context
		context.close();
	}
}
