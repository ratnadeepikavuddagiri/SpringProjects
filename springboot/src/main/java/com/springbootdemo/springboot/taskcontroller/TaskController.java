package com.springbootdemo.springboot.taskcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	
	@GetMapping("/task")
	public String task() {
		return "Task demonstration";
	}
	
	@GetMapping("/task/showMyInfo")
	public String showInfo() {
		return "Name:Deepika  City:Tanuku  State:Andhra Pradesh  Dream_job:Software Developer";
	}
	
	@GetMapping("/task/showMyHobbies")
	public List<String> showHobbies() {
		return List.of("A","B","C");
	}

}
