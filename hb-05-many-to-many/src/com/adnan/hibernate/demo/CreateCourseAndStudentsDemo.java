package com.adnan.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Course;
import com.adnan.hibernate.demo.entity.Instructor;
import com.adnan.hibernate.demo.entity.InstructorDetail;
import com.adnan.hibernate.demo.entity.Review;
import com.adnan.hibernate.demo.entity.Student;



public class CreateCourseAndStudentsDemo {

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
				
				// 2: create the courses
				Course course1 = new Course("PK2");
				Course course2 = new Course("Software Tecnick");
				Course course3 = new Course("Gymnastik");
				
			
				
				// 3: add the Adnan which has the ID of 1 to the Courses
				course1.addStudent(session.get(Student.class,1 ));
				course2.addStudent(session.get(Student.class,1 ));
				course3.addStudent(session.get(Student.class,1 ));
				
				
				// 4: save the Courses
				System.out.println("Saving the Courses...");
				System.out.println(course1);
				System.out.println(course2);
				System.out.println(course3);
				
				session.save(course1);
				session.save(course2);
				session.save(course3);
			
				
				
			
				
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
