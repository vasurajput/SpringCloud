package com.javadream.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadream.dao.UserDao;
import com.javadream.model.User;

@RestController
@RequestMapping("info")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@GetMapping("/test")
	public String demo() {
		return "Nice Try! You have learned Spring Boot Security With MySql";
	}
}
