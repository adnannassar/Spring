package com.adnan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotaionDemoApp {
	public static void main(String[] args) {
		// read spring configurations file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach fußballCoach1 = context.getBean("fußballCoach" , Coach.class);
		Coach fußballCoach2 =  context.getBean("fußballCoach" , Coach.class);
		
		
		// check if they are the same objects
		if( fußballCoach1.equals(fußballCoach2)) {
			System.out.println("Yes , they are pointing at the same object");
		}else {
			System.out.println("No , they are not pointing at the same object");
		}
		
		System.out.println("The memory address for fußballCoach: "+fußballCoach1);
		System.out.println("The memory address for tenissCoach: "+fußballCoach2);
		// call a method on the bean
		System.out.println(fußballCoach1.getdailyWorkout());
		System.out.println(fußballCoach1.getDailyFortune());
	    System.out.println(fußballCoach1.getGehalt());
		
	  
		// close the context
		context.close();
	}
}
