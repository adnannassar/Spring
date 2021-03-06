package com.adnan.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Course;
import com.adnan.hibernate.demo.entity.Instructor;
import com.adnan.hibernate.demo.entity.InstructorDetail;
import com.adnan.hibernate.demo.entity.Review;
import com.adnan.hibernate.demo.entity.Student;



public class DeleteOneCourseDemo {

	public static void main(String[] args) {
	
		// create session factory
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class)
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
		// create session 
			Session session = factory.getCurrentSession();
			
			try {
				// use the session to save Java object in database 
					
				
				// 1: start a transaction
				System.out.println("Starting the transaction...");
				session.beginTransaction();
				
				// 2: deleting the course
				session.delete(session.get(Course.class, 10));
				// 3: commit the transaction
				System.out.println("Commiting the transaction...");
				session.getTransaction().commit();
				
				System.out.println("DONE!");
				
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			finally {
				// add clean up code 
				session.close();
				factory.close();
			}

	}

}
