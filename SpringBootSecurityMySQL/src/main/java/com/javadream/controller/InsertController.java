package com.javadream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadream.dao.UserDao;

@RestController
public class InsertController {

	@Autowired
	private UserDao dao;
	
	@GetMapping("/insert")
	public String insert() {
		try {
			int insertUser = dao.insertUser();
			return "Insert Status= "+insertUser;
		} catch (Exception e) {
			e.printStackTrace();
			return "Some Technical Error Try Again";
		}
		
	}
}
