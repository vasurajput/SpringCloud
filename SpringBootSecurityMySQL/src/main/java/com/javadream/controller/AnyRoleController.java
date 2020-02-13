package com.javadream.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anyRoleAPIs")
public class AnyRoleController {

	
	@GetMapping("/testAPI")
	public String demo() {
		return "Nice Try! You have learned Spring Boot Security With MySql";
	}
}
