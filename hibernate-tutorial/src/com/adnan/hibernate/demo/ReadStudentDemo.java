package com.adnan.hibernate.demo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.adnan.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	static SessionFactory factory;

	public static void main(String[] args) {
		System.out.println("Reading from DATABASE: ");
		List<Student> theStudents = getAllStudents();
		if (theStudents != null) {
			theStudents.forEach(a -> System.out.println(a));
		} else {
			System.out.println("NULL");
		}
	
		
		/*
		System.out.println("After Update : ");
		// updating the object with the id "2"
		if (updateStudentsLastName(2, "Nassar")) {
			List<Student> theStudents1 = getAllStudents();
			if (theStudents1 != null) {
				theStudents1.forEach(a -> System.out.println(a));
			} else {
				System.out.println("NULL");
			}
		}
		*/
		
		/*
		System.out.println("After Deleting : ");
		if (deleteStudent(6)) {
			List<Student> theStudents2 = getAllStudents();
			if (theStudents2 != null) {
				theStudents2.forEach(a -> System.out.println(a));
			} else {
				System.out.println("NULL");
			}
		}
	*/
	}

	static Session createSession() {
		// create session factory
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		if (session != null)
			return session;
		return null;
	}

	static Student getStudentByID(int id) {
		Session session = createSession();
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

	static List<Student> getAllStudents() {
		Session session = createSession();
		try {
			// use the session to read object from database

			// find the student's id "primary Key"
			// but first we need to start a transaction
			session.beginTransaction();
			// retrive all students in the data base
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// retrive students from the data base with some conditions
			// List<Student> theStudents = session
			// .createQuery("from Student s where s.lastName = 'Nassar'" + " or s.firstName
			// = 'Yasin'")
			// .getResultList();

			// commit the transaction
			session.getTransaction().commit();
			if (theStudents != null) {
				System.out.println("DONE!");
				return theStudents;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}

		return null;
	}

	static boolean updateStudentsLastName(int id, String lastName) {
		Session session = createSession();
		if (session != null) {
			try {
				// starting the session
				session.beginTransaction();

				// 1.a : retrieving the object then edit it before save it again
				// session.get(Student.class, id).setLastName(lastName);

				// 1.b : or using query
				session.createQuery("update Student set lastName = 'NASSAROWSKI' where ID =  " + id).executeUpdate();

				// 2 : commetting
				session.getTransaction().commit();

				return true;

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				factory.close();
			}
		} else {
			return false;
		}
		return false;
	}

	static boolean deleteStudent(int id) {
		Session session = createSession();
		if (session != null) {
			try {
				// starting the session
				session.beginTransaction();

				// 1.a : retrieving the object then delete it before save it agai
				// Student s1 = session.get(Student.class, id);
				// session.delete(s1);

				// 1.b : or using query
				session.createQuery("delete from Student where ID =  " + id).executeUpdate();

				// 2 : commetting
				session.getTransaction().commit();

				return true;

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				factory.close();
			}
		} else {
			return false;
		}
		return false;
	}
}
