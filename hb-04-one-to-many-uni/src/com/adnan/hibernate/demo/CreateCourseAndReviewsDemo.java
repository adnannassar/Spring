package com.adnan.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Course;
import com.adnan.hibernate.demo.entity.Instructor;
import com.adnan.hibernate.demo.entity.InstructorDetail;
import com.adnan.hibernate.demo.entity.Review;
import com.adnan.hibernate.demo.entity.Student;



public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
	
		// create session factory
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class)
					.buildSessionFactory();
		// create session 
			Session session = factory.getCurrentSession();
			
			try {
				// use the session to save Java object in database 
					
				
				// 1: start a transaction
				System.out.println("Starting the transaction...");
				session.beginTransaction();
				
				// 2: create a course
				Course course = new Course("Pacman - How to Score One Million Points");
				
				// 3: add some reviews
				course.addReview(new Review("I loved it"));
				course.addReview(new Review("Cooooool!!"));
				course.addReview(new Review("That was nice"));
				course.addReview(new Review("very bad !! :/"));
				// 4: save the course what will also save all the reviews
				
				session.save(course);
				
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
