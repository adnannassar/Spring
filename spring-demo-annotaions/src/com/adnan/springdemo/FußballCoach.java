package com.adnan.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FußballCoach implements Coach {

	@Qualifier("bonusBerechnung")
	@Autowired
	private BankingSystem bankingSystem;
	
	
	private FortuneService fortuneService;

	public FußballCoach() {
	}
	
	@Qualifier("randomService")
	@Autowired
	public void setForuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getdailyWorkout() {
		return "Practice your Legs";
	}

	@Override
	public String getDailyFortune() {
		return "Fußball Coach: " + fortuneService.getFortune();
	}

	@Override
	public double getGehalt() {
		return bankingSystem.getGehalt();
	}
	
	
	
	@PostConstruct
	public void doMyStartpStuff() {
		System.out.println("Setting Up the stuff");
	}
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("Cleaing up !!");
	}
	

}
