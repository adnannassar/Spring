package com.adnan.hibernate.demo;


import java.nio.channels.SeekableByteChannel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.adnan.hibernate.demo.entity.Instructor;
import com.adnan.hibernate.demo.entity.InstructorDetail;
import com.adnan.hibernate.demo.entity.Student;



public class DeleteInstructorDetailsDemo {

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
				
				// 2: get the InstructorDetails by primary key
				InstructorDetail instructorDetail = session.get(InstructorDetail.class, 5);
				if(instructorDetail!=null) {
					System.out.println("Details: " +instructorDetail);
				}else {
					System.out.println("ERORR!!");
				}
				
				// 3: remove the associated object
				// break the bi-directional link
				instructorDetail.getInstructor().setInstructorDetail(null);
			
				// 4: deleting the instructorDetail and this will also delete the instructor
				// because of the CascadeType.ALL
				System.out.println("Deleting... ");
				session.delete(instructorDetail);
				
				// 5: commit the transaction
				System.out.println("Commiting the transaction...");
				session.getTransaction().commit();
				
				System.out.println("DONE!");
				
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			finally {
				//handle the connection leak issue
				session.close();
				factory.close();
			}

	}

}
