package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MainService;

@RestController
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private MainService service;

	@GetMapping("/")
	public String test() {
		try {
			int saveStatus = service.save();
			logger.info("saveStatus= " + saveStatus);
			if (saveStatus == 1) {
				return "Nice Try Champ !!";
			} else {
				return "Some Technical Error Please Try again";
			}
		} catch (Exception e) {
			logger.error("Exception: " + e);
			return "Some Technical Error Please Try again";
		}
	}
}
