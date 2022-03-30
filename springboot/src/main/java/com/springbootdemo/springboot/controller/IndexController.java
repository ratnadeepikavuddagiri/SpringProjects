package com.springbootdemo.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

//	@GetMapping("/")
//	public String index() {
//		return "Hello Spring Boot!";
//	}
//	
	@GetMapping("/jsonMessage")
	public List<String> jsonMessage() {
		return List.of("Hello", "Spring", "Boot","!");
	}

}
