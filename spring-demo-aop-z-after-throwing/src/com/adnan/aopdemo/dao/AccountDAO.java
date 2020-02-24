package com.adnan.aopdemo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adnan.aopdemo.Account;

@Component // to be found using component scanning
public class AccountDAO {

	private String name, serviceCode;

	public List<Account> findAccounts() {

		// create a sample account and add them to the list and return the list
		return new ArrayList<Account>(
				Arrays.asList(new Account("Adnan", "100"), new Account("Hamadeh", "80"), new Account("Badari", "50")));
	}

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n");

	}

	public void addAccount(Account a, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n");

	}

	public void setName(String name) {
		System.out.println(getClass() + " : in setName()");
		this.name = name;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public String getName() {
		System.out.println(getClass() + " : in getName()");
		return name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " : in getServiceCode()");
		return serviceCode;
	}
}
