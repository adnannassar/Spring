package com.adnan.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Instructor;
import com.adnan.hibernate.demo.entity.InstructorDetail;
import com.adnan.hibernate.demo.entity.Student;



public class CreateDemo {

	public static void main(String[] args) {
	
		// create session factory
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.buildSessionFactory();
		// create session 
			Session session = factory.getCurrentSession();
			
			try {
				// use the session to save Java object in database 
					
				// 1: create the Objects that we want to save
			
				System.out.println("Creating a Instructor Object...");
				Instructor instructor1 = new Instructor("Adnan" , "Nassar" , "adnan.anssar90@gmail.com");
				System.out.println("Creating a InstructorDetail Object...");
				InstructorDetail instructorDetail1 = new InstructorDetail("Adnan/Youtube.com" , "Coding");
				
				// 2: associate the objects
				System.out.println("Associating the objects...");
				instructor1.setInstructorDetail(instructorDetail1);
				
				// 3: start a transaction
				System.out.println("Starting the transaction...");
				session.beginTransaction();
				
				// 4: save the objects
				System.out.println("Saving the objects...");
				// Note : this will also save the "instructorDetail1" object because of the
				// cascadeType.ALL
				session.save(instructor1);
				
				// 5: commit the transaction
				System.out.println("Commiting the transaction...");
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
