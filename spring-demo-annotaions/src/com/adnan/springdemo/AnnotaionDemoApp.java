package com.adnan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotaionDemoApp {
	public static void main(String[] args) {
		// read spring configurations file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach fu�ballCoach1 = context.getBean("fu�ballCoach" , Coach.class);
		Coach fu�ballCoach2 =  context.getBean("fu�ballCoach" , Coach.class);
		
		
		// check if they are the same objects
		if( fu�ballCoach1.equals(fu�ballCoach2)) {
			System.out.println("Yes , they are pointing at the same object");
		}else {
			System.out.println("No , they are not pointing at the same object");
		}
		
		System.out.println("The memory address for fu�ballCoach: "+fu�ballCoach1);
		System.out.println("The memory address for tenissCoach: "+fu�ballCoach2);
		// call a method on the bean
		System.out.println(fu�ballCoach1.getdailyWorkout());
		System.out.println(fu�ballCoach1.getDailyFortune());
	    System.out.println(fu�ballCoach1.getGehalt());
		
	  
		// close the context
		context.close();
	}
}
