package com.adnan.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName , lastName , country , favoriteLanguage; 
	private LinkedHashMap<String, String> countryOptions;
	private String [] operatingSystems;
	
	public Student() {
		// populate country options : used ISO country code
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("DE","Germany");
		countryOptions.put("FR","France");
		countryOptions.put("USA","United States of America");
		countryOptions.put("IT","Italy");
		countryOptions.put("SYR","Syria");
	}
	// setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	// getters
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getCountry() {
		return country;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	
	
}
