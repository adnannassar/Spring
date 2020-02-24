package com.adnan.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adnan.aopdemo.dao.AccountDAO;


public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the container 
		AccountDAO theAccountDAO = context.getBean("accountDAO" , AccountDAO.class);
		
		// call the method
		theAccountDAO.addAccount();
		
		// close the context
		context.close();
	}

}
