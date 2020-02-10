package com.adnan.springdemo;

public class MyApp {
	public static void main(String[] args) {
		// create the object 
		Coach theCoach = new TrackCoach(new FortuneService() {
			
			@Override
			public String getFortune() {
				return "Inner Class Implementaion Test !!";
			}
		});
		// use the object
		System.out.println(theCoach.getDailyWorkout());
	}
}
