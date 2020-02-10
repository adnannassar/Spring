package com.adnan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// retrieve bean form the spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// check if they are the same Beans !!
		if (theCoach.equals(alphaCoach)) {
			System.out.println("Ja , they arey pointing to the same object");
			
		} else {
			System.out.println("no , they arey pointing to an other object");
		}
		
		System.out.println("Memory location for theCoach: " + theCoach);
		System.out.println("Memory location for alphaCoach: " + alphaCoach);
		
		
		// call methods on the bean
		System.out.println("Beans: " + theCoach.getDailyWorkout());
		System.out.println("Injection: " + theCoach.getDailyFortune());

		// close the context
		context.close();
	}

}
