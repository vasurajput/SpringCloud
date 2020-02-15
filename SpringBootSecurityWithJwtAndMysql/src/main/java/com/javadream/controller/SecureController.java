package com.javadream.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

	
	@GetMapping("/SecureAPI")
	public String getSecureEndPoint() {
		return "Nice try! You have learned Spring Boot JWT Security";
	}
}
