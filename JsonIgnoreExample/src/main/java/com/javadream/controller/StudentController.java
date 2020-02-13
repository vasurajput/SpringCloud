package com.javadream.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadream.model.Student;

@RestController
public class StudentController {

	@GetMapping("/getAllStudent")
	public List<Student> showStudentDetail() {
		List<Student> studentList = Arrays.asList(new Student(101, "vasu", "vasu@gmail.com"),
				new Student(102, "vishu", "vishu@gmail.com"));
		return studentList;
	}
}
