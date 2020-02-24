package com.adnan.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component // to be found using component scanning
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass() +": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
}
