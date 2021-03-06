package com.adnan.aopdemo;

import java.util.List;

import javax.sound.midi.Soundbank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adnan.aopdemo.dao.AccountDAO;
import com.adnan.aopdemo.dao.MembershipDAO;


public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// read spring config java class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the container 
		AccountDAO theAccountDAO = context.getBean("accountDAO" , AccountDAO.class);
		
		
		// call the method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println("The final Result: ");
		System.out.println(theAccounts);
		// close the context
		context.close();
	}

}
