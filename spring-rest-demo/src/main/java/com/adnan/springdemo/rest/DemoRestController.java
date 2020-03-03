package com.adnan.springdemo.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/test")
public class DemoRestController {
	
	
	// add code for the "/hello" endpoint
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	
}
