package com.adnan.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	
	
	@Override
	public String getdailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	@Override
	public double getGehalt() {
		return 10.000;
	}
	
	

}
