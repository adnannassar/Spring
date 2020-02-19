package com.adnan.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Course;
import com.adnan.hibernate.demo.entity.Instructor;
import com.adnan.hibernate.demo.entity.InstructorDetail;
import com.adnan.hibernate.demo.entity.Review;
import com.adnan.hibernate.demo.entity.Student;



public class AddCoursesForAdnanDemo {

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
				
				// 2: create & save a course
				Course course = new Course("Spring-boot Kurs");
				session.save(course);
				
				
				// 3: create some students
				Student s1 = new Student("Adnan", "Nassar","adnan.nassar90@gmail.com");
				Student s2 = new Student("Yasin", "Akkad","yasin-akkad@gmail.com");
				Student s3 = new Student("Bader", "Lababidi","bader-lababidi@gmail.com");
				Student s4 = new Student("Hamoudeh", "Nassar","hamido-nassar@gmail.com");
				
				// 4: add the Students to the Course
				course.addStudent(s1);
				course.addStudent(s2);
				course.addStudent(s3);
				course.addStudent(s4);
				
				
				// 5: save the Students
				System.out.println("Saving the Students...");
				System.out.println(s1);
				System.out.println(s2);
				System.out.println(s3);
				System.out.println(s4);
				
				session.save(s1);
				session.save(s2);
				session.save(s3);
				session.save(s4);
				
				
			
				
				// 6: commit the transaction
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
