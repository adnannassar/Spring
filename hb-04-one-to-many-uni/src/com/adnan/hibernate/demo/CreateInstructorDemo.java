package com.adnan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Course;
import com.adnan.hibernate.demo.entity.Instructor;
import com.adnan.hibernate.demo.entity.InstructorDetail;
import com.adnan.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session to save Java object in database

			// 1: start a transaction
			System.out.println("Starting the transaction...");
			session.beginTransaction();

			// 2 : get Instructor from Database
			Instructor instructor = session.get(Instructor.class, 2);
			// 3: create some courses
			Course c1 = new Course("Air Guitar2 - the Ultimate Guide");
			Course c2 = new Course("The Pinball2 - Master Class");
			Course c3 = new Course("Air Guitar2 - Advanced");
			// 4: add courses to Instructor
			instructor.add(c1);
			instructor.add(c2);
			instructor.add(c3);
			// 5 : save the courses
			session.save(c1);
			session.save(c2);
			session.save(c3);
			// 6: commit the transaction
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();

			System.out.println("DONE!");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
