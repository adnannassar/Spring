package com.adnan.hibernate.demo;


import javax.jws.soap.SOAPBinding;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Course;
import com.adnan.hibernate.demo.entity.Instructor;
import com.adnan.hibernate.demo.entity.InstructorDetail;
import com.adnan.hibernate.demo.entity.Student;



public class DeleteCoursesDemo {

	public static void main(String[] args) {
	
		// create session factory
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.buildSessionFactory();
		// create session 
			Session session = factory.getCurrentSession();
			
			try {
				// use the session to save Java object in database 
					
			
				
				// 1: start a transaction
				System.out.println("Starting the transaction...");
				session.beginTransaction();
			
				// 2: get the Instructor from database
				Instructor instructor = session.get(Instructor.class, 2);
				
				// 3: get courses from Instructor
			
				System.out.println("The Instructor: " + instructor);
				System.out.println("Before Deleting : ");
				System.out.println("The Courses of this Instructor : \n"+instructor.getCourses());
				
				// 4: delete course
				System.out.println("After Deleting : ");
				session.delete(instructor.getCourses().get(0));
				System.out.println("The Courses of this Instructor : \n"+instructor.getCourses());
				
				// 5: commit the transaction
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
