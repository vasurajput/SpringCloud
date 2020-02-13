package com.javadream.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadream.dao.UserDao;
import com.javadream.model.User;

@RestController
@RequestMapping("signUp")
public class InsertController {
	private static final Logger logger = LoggerFactory.getLogger(InsertController.class);
	private static final String GLOBAL_ERROR = "Some technical Error try again!";

	@Autowired
	private UserDao dao;
	
	@GetMapping("/dummy")
	public String test() {
		return "Nice try";
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody User user) {
		try {
			logger.info("vvv::  user= "+user);
			if(user == null) {
				return GLOBAL_ERROR;
			}
			int insertUser = dao.insertUser(user);
			return "Insert Status= "+insertUser;
		} catch (Exception e) {
			e.printStackTrace();
			return "Some Technical Error Try Again";
		}
		
	}
}
