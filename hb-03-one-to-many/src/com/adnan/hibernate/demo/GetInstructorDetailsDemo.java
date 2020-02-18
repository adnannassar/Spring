package com.adnan.hibernate.demo;


import java.nio.channels.SeekableByteChannel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Instructor;
import com.adnan.hibernate.demo.entity.InstructorDetail;
import com.adnan.hibernate.demo.entity.Student;



public class GetInstructorDetailsDemo {

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
				// use the session to delete Java object in database 
					
				
				// 1: start a transaction
				System.out.println("Starting the transaction...");
				session.beginTransaction();
				
				// 2: get the InstructorDetails by primary key
				InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
					
			
				// 3: printing the infos of instructorDetail and instructor 
				System.out.println("Retrived Data : \n" + instructorDetail + ": \n" + instructorDetail.getInstructor());
				
				// 5: commit the transaction
				System.out.println("Commiting the transaction...");
				session.getTransaction().commit();
				
				System.out.println("DONE!");
				
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			finally {
				//handle the connection leak issue
				session.close();
				factory.close();
			}

	}

}
