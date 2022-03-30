package com.springbootdemo.springboot.homecontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String welcome() {
		return "Hello visitor!";
	}
}
