package com.kodnest.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestControllers {

	@GetMapping("/data")
	public Map<String, String>showData(){
		Map<String, String> response = new HashMap<>();
		response.put("Message", "Hello");
		response.put("role", "User");
		return response;
	}
}
