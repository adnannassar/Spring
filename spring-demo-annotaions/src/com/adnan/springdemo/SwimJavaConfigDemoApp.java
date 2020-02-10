package com.adnan.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigDemoApp {
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		SwimCoach swimCoach = context.getBean("swimCoach" , SwimCoach.class);
	
		
	
		// call a method on the bean
		System.out.println(swimCoach.getdailyWorkout());
		System.out.println(swimCoach.getDailyFortune());
	    System.out.println(swimCoach.getGehalt());
	    System.out.println(swimCoach.getEmail());
	    System.out.println(swimCoach.getTeam());
		
	  
		// close the context
		context.close();
	}
}
