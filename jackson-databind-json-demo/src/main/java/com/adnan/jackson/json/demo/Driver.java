package com.adnan.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			// create the object mapper
			ObjectMapper mapper = new ObjectMapper();
			// read JSON file and map/convert to Java POJO from data/sample-lite.json
			//
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			// print the Student Info
			System.out.println(theStudent);
		} catch (Exception e) {
				e.printStackTrace();
		}

	}

}
