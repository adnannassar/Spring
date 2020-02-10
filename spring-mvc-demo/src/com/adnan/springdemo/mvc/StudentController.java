package com.adnan.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//create a method to show a Form
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		// create a new Student Object
		Student theStudent = new Student();
		// add the student Object as a Model attribute
		
		theModel.addAttribute("student", theStudent);
		
		
		return "student-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println("TheStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		return "student-confirmation";
		
	}
}
