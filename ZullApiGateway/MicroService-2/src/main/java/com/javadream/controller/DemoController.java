package com.javadream.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/microservice-2")
	public String microService2() {
		return "HI This is MicroService-2 Response";
	}
}
