package com.javadream.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadream.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	public static List<Student> studentList = new ArrayList<Student>();
	private JSONParser parser = new JSONParser();

	public StudentController() {
		studentList.add(new Student(111, "Vasu", "vashurajput005@gmail.com"));
		studentList.add(new Student(112, "Vishu", "vishu@gmail.com"));
		studentList.add(new Student(111, "koku", "koku@gmail.com"));
		studentList.add(new Student(111, "ayush", "aysuh@gmail.com"));
	}

	@GetMapping("/showAllStudent")
	public List<Student> showAllStudents() {
		logger.info("vvv::  showAllStudents endPoint Calling");
		return studentList;
	}

	@PostMapping("addStudent")
	public List<Student> addNewStudent(@RequestBody String payload) {
		try {
			logger.info("vvv::  payload= " + payload);
			JSONObject payloadObj = (JSONObject) parser.parse(payload);
			Student student = new Student(Long.parseLong(payloadObj.get("rollNo").toString()), payloadObj.get("name").toString(), payloadObj.get("email").toString());
		    studentList.add(student);
		    return studentList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
