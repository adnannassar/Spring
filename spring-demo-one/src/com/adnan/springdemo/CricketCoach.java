package com.adnan.springdemo;

public class CricketCoach  implements Coach{
	private FortuneService fortuneService;
	private String emailAddress, team;
	
	public CricketCoach() {
			System.out.println("CricketCoach: inside default constructor");
	}
	

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: sett method : setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "practice fast bowling for 15 minutes";
	}
	
	@Override
	public String getDailyFortune() {
		return "Cricket Coach: "+fortuneService.getFortune();
	}
	
	//setters
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("CricketCoach: sett method : setEmailAddress");

	}
	public void setTeam(String team) {
		this.team = team;
		System.out.println("CricketCoach: sett method : setTeam");
	}
	
	// getters
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getTeam() {
		return team;
	}
}
