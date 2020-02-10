package com.adnan.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	@Value("${email}")
	private String email;
	@Value("${team}")
	private String team;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getdailyWorkout() {
		return "swim a 1000 meters as warmup";
	}

	@Override
	public String getDailyFortune() {
		return "SwimCoach "+ fortuneService.getFortune();
	}

	@Override
	public double getGehalt() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getEmail() {
		return email;
	}
	public String getTeam() {
		return team;
	}

}
