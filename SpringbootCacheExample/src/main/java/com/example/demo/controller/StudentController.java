package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String test() {
		return "Nice Try";
	}

	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent() {
		List<Student> allStudent = service.getAllStudent();
		return allStudent;
	}
	
	@DeleteMapping("/deleteStudent/{studentId}")
	public 	void deletStudent(@PathVariable("studentId") Long studentId) {
		service.deleteStudent(studentId);
	}
}
