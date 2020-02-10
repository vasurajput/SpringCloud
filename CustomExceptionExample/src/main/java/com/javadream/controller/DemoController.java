package com.javadream.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javadream.exception.UserNotFoundException;

@RestController
public class DemoController {
	
	static Map<Integer, String> dummyMap = new LinkedHashMap<Integer, String>();
	
	public DemoController() {
		dummyMap.put(1, "Vasu Rajput");
		dummyMap.put(2, "Vishu Rajput");
		dummyMap.put(3, "Koku Rajput");
		dummyMap.put(4, "Oshu Rajput");
	}

	@GetMapping("/test/{id}")
	public String test(@PathVariable("id") Integer id) {
		String name = dummyMap.get(id);
		if(name == null) {
			throw new UserNotFoundException("id- "+id);
		}
		return "Nice Try  "+name;
	}
}
