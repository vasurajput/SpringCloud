package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/")
	public String entryPoint() {
		return "This is entry point";
	}
	
	@GetMapping("/api1")
	public String api1() {
		return "This is entry point";
	}
	
	@GetMapping("/api2")
	public String api2() {
		return "This is api2";
	}
}
