package com.adnan.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoApp {
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		Coach fuﬂballCoach1 = context.getBean("fuﬂballCoach" , Coach.class);
		Coach fuﬂballCoach2 =  context.getBean("fuﬂballCoach" , Coach.class);
		
		
		// check if they are the same objects
		if( fuﬂballCoach1.equals(fuﬂballCoach2)) {
			System.out.println("Yes , they are pointing at the same object");
		}else {
			System.out.println("No , they are not pointing at the same object");
		}
		
		System.out.println("The memory address for fuﬂballCoach: "+fuﬂballCoach1);
		System.out.println("The memory address for tenissCoach: "+fuﬂballCoach2);
		// call a method on the bean
		System.out.println(fuﬂballCoach1.getdailyWorkout());
		System.out.println(fuﬂballCoach1.getDailyFortune());
	    System.out.println(fuﬂballCoach1.getGehalt());
		
	  
		// close the context
		context.close();
	}
}
