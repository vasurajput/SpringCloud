package com.javadream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/microservice-1")
	public String testing() {
		return "HI This is MicroService-1 Response";
	}
}
