package com.adnan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean form the spring container
		Coach theCoach = context.getBean("myCricketCoach",Coach.class);
		// call methods on the bean 
		System.out.println("Beans: "+theCoach.getDailyWorkout());
		System.out.println("Injection: "+ theCoach.getDailyFortune());
		// close the context
		context.close();
	}

}
