package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

	@GetMapping("/teacher")
	public String teacherEndpoint() {
		return "Nice Try This is Teacher Service";
	}
}
