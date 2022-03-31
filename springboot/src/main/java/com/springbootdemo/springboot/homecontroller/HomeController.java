package com.springbootdemo.springboot.homecontroller;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String welcome() {
		return "Hello visitor!  Visiting Time"+new Date(System.currentTimeMillis());
	}
}
