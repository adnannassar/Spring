package com.adnan.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.adnan.aopdemo.Account;

@Component // to be found using component scanning
public class AccountDAO {

	private String name, serviceCode;

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n");

	}

	public void addAccount(Account a) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n");

	}

	public void setName(String name) {
		System.out.println(getClass()+" : in setName()");
		this.name = name;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" : in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public String getName() {
		System.out.println(getClass()+" : in getName()");
		return name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+" : in getServiceCode()");
		return serviceCode;
	}
}
