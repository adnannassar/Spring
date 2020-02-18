package com.adnan.hibernate.demo;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Course;
import com.adnan.hibernate.demo.entity.Instructor;
import com.adnan.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session to save Java object in database

			// 1.a: start a transaction
			System.out.println("Starting the transaction...");
			session.beginTransaction();

			// 1.b: Hibernate query with HQL
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i join Fetch i.courses where i.id=:theInstructorId", Instructor.class);
			
			
			// 2: set parameter on query
			query.setParameter("theInstructorId",2);

			
			// 3: Execute the query and get Instructor
			Instructor instructor = query.getSingleResult();
			
			
			// 4: commit the transaction
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			session.close();
			System.out.println("DONE!");
			
			// 5: get courses from Instructor
			System.out.println("The Instructor: " + instructor);
			System.out.println("The Courses of this Instructor : \n" + instructor.getCourses());

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// add clean up code

			factory.close();
		}

	}

}
