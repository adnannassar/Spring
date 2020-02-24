package com.adnan.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adnan.aopdemo.dao.AccountDAO;
import com.adnan.aopdemo.dao.MembershipDAO;


public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the container 
		AccountDAO theAccountDAO = context.getBean("accountDAO" , AccountDAO.class);
		MembershipDAO theMembershipDAP =context.getBean("membershipDAO",MembershipDAO.class);
		// call the method
		theAccountDAO.addAccount();
		theMembershipDAP.addAccount();
		System.out.println("The result is : "+theMembershipDAP.summe(10,20)+"\n");
		
		theAccountDAO.addAccount(new Account());
		
		
		System.out.println("\ncalling the setters and the getters....");
		// call the setters
		theAccountDAO.setName("Adnan");
		theAccountDAO.setServiceCode("silver");
		// call the getter
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		// close the context
		context.close();
	}

}
