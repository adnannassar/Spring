package com.adnan.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.javafx.sg.prism.NGShape.Mode;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	// need a controller method to process the initial HTML form
	public String processForm() {
		return "helloworld";
	}

	
	// new Controller method to read from data and add data to the model
	@RequestMapping("/processFormVersion2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		// convert the data to all caps 
		theName = theName.toUpperCase();
		// create the message
		String result ="Yo! " + theName + " you are wlmc";
		// add message to the model
							//name    //value
		model.addAttribute("message" , result);
		
		
		return "helloworld";

	}
	
	@RequestMapping("/processFormVersion3")
	public String processFormVersion3(@RequestParam("studentName")String theName, Model model) {
	
		// convert the data to all caps 
		theName = theName.toUpperCase();
		// create the message
		String result ="Yo! " + theName + " you are wlcm from processFormVersion3";
		// add message to the model
							//name    //value
		model.addAttribute("message" , result);
		
		
		return "helloworld";

	}

}
