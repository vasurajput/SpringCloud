package com.javadream.controller;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/restTemplateDemo")
public class RestTemplateDemoController {

	private static final Logger logger = LoggerFactory.getLogger(RestTemplateDemoController.class);
	private final String GLOBAL_ERROR = "Some technical Error Please try again after some time";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("call_MS2_showAllStudent_endPoint")
	public String callMicroservice_2_ShowAllStudent() {
		try {
			String responseFromMS2 = restTemplate.getForObject("http://localhost:8082/student/showAllStudent",
					String.class);
			logger.info("vvv::  responseFromMS2= " + responseFromMS2);
			return responseFromMS2;
		} catch (Exception e) {
			e.printStackTrace();
			return GLOBAL_ERROR;
		}
	}
	
	@GetMapping("call_MS2_addStudent_endPoint")
	public String call_MS_2_addStudent_endPoint() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject studentObj = new JSONObject();
		studentObj.put("rollNo", 199);
		studentObj.put("name", "New_Student");
		studentObj.put("email", "new.student@gmail.com");
		org.springframework.http.HttpEntity<String> s = new org.springframework.http.HttpEntity<String>(studentObj.toString(),headers);
		String postForObject = restTemplate.postForObject("http://localhost:8082/student/addStudent", s, String.class);
		return postForObject;
	}
	
	
}
