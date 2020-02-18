package com.adnan.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Instructor;
import com.adnan.hibernate.demo.entity.InstructorDetail;
import com.adnan.hibernate.demo.entity.Student;



public class DeleteDemo {

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
				
				// 2: get the Instructor by primary key
				Instructor instructor1 = session.get(Instructor.class, 2);
					
			
				// 3: delete the objects
				System.out.println("Deleting the objects...");
				// Note : this will also delete the "instructorDetail1" object because of the
				// cascadeType.ALL
				session.delete(instructor1);
				
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
