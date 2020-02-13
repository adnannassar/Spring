package com.adnan.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	
	
	
	private String firstName;
	
	
	@NotNull(message = "is required") // required
	@Size(min = 1 , message = "is required")
	private String lastName;
	
	
	@NotNull(message = "is required") // required
	@Min(value = 1 , message = "must be greater than zero")
	@Max(value = 10 , message = "must be less than 10")
	private Integer freePasses;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postalCode;
	
	
	private String courseCode;
	
	// getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getCourseCode() {
		return courseCode;
	}
	
	
	// setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}
