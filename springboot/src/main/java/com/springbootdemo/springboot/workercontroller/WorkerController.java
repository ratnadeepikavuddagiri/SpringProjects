package com.springbootdemo.springboot.workercontroller;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.springboot.model.Worker;
@RestController
public class WorkerController {
	@GetMapping("/worker/showWorker")
	public Worker showWorker() {
		Worker worker = new Worker(9,"Deepika","Vuddagiri",20000,Date.valueOf("2022-03-29"),"Admin","deepika@gmail.com");
		return worker;
	}
	
	@GetMapping("/worker/all/showWorkers")
	public List<Worker> showWorkers() {
		List<Worker> workers = List.of(new Worker(9,"Deepika","Vuddagiri",20000,Date.valueOf("2022-03-29"),"Admin","deepika@gmail.com"),new Worker(10,"Jhansi","Pothuru",30000,Date.valueOf("2022-03-30"),"HR","jhansi@gmail.com"),new Worker(9,"Nandini","Neelam",10000,Date.valueOf("2022-03-31"),"HR","nandini@gmail.com"));
		return workers;
	}

}
