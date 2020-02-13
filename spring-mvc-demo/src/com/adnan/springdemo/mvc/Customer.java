package com.adnan.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	
	
	
	private String firstName;
	
	
	@NotNull(message = "is required")
	@Size(min = 1 , message = "is required")
	private String lastName;
	
	
	@Min(value = 1 , message = "must be greater than zero")
	@Max(value = 10 , message = "must be less than 10")
	private int freePasses;
	
	
	
	// getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public int getFreePasses() {
		return freePasses;
	}

	
	
	// setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
}
