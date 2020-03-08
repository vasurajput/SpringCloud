package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MyModel;

@RestController
public class NameController {

	@Value("${myname} ")
	private String name;
	
	@Autowired
	private MyModel model;
	
	@GetMapping("/")
	public String test() {
		return "My Name is "+name
				+", i am always "+model.isValue()
				+", my messgage to you is  "+model.getMessage()
				+", i want to be number  "+model.getNumber();
	}
}
