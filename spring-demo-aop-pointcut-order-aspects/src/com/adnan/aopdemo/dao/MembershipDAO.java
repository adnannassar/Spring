package com.adnan.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass()+ ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT\n");
	}
	public int summe(int a , int b) {
		return a+b;
	}
}
