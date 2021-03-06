package com.adnan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	// create session 
		Session session = factory.getCurrentSession();
		
		try {
			// use the session to save Java object in database 
				
			// 1: create a student object that we want to save
			System.out.println("Creating new Studet Objects");
			Student s1 = new Student("Yasin" , "Akkad" , "yasin-Akkad@gmail.com");
			Student s2 = new Student("Hamouda" , "Nassar" , "hamouda-anssar@gmail.com");
			Student s3 = new Student("Bader" , "Lababidi" , "bader-lababidi@gmail.com");
			// 2: start a transaction
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			// 3: save the student object
			System.out.println("saving the objects...");
			session.save(s1);
			session.save(s2);
			session.save(s3);
			// 4: commit the transaction
			System.out.println("commiting the transaction...");
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

}
