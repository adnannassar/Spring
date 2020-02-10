package com.adnan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean form the spring container
		CricketCoach theCoach = context.getBean("myCricketCoach",CricketCoach.class);
		// call methods on the bean 
		System.out.println("Beans: "+theCoach.getDailyWorkout());
		System.out.println("Injection: "+ theCoach.getDailyFortune());
		System.out.println("Reading the injected attributs : ");
		System.out.print("Email: " + theCoach.getEmailAddress());
		System.out.print("/ Team: " + theCoach.getTeam()+"\n");
		// close the context
		context.close();
	}

}
