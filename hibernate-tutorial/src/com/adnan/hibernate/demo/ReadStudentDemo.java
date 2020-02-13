package com.adnan.hibernate.demo;

import java.nio.channels.SeekableByteChannel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.adnan.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		Student s1 = getStudentByID(1);
		if(s1!=null) {
			System.out.println("Retvied Object : " + s1);
		}
	}

	static Student getStudentByID(int id) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session to read object from database

			// find the student's id "primary Key"
			// but first we need to start a transaction
			session.beginTransaction();
			// retrive the Student object
			Student s1 = session.get(Student.class, id);
			// commit the transaction
			session.getTransaction().commit();
			// printing the Student infrmations
			if (s1 != null) {
				System.out.println("DONE!");
				return s1;
			} else {
				System.out.println("Wrong ID !!!");
				return null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}

		return null;

	}
}
