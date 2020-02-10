package com.javadream.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

	@GetMapping("/index")
	@HystrixCommand(fallbackMethod = "fallback_index", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public String index() {
		try {
			Thread.sleep(3000);
			return "Hi Welcome, Thanks for learning about Hystix";
		} catch (Exception e) {
			e.printStackTrace();
			return "Some Technical Error try Again";
		}

	}

	private String fallback_index() {
		return "Request fails. It takes long time to response";

	}
}
