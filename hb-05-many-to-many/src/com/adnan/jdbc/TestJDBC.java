package com.adnan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimezone=UTC";
		String user = "studentAdmin" ;
		String password = "2211" ;
		
		
		try {
			System.out.println("Conecting to database: " + jdbcURL);
			Connection myConnection = DriverManager.getConnection(jdbcURL,user,password);
			System.out.println("Connection successful...");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
	}

}
