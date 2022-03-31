package com.workers.jdbcexample.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workers.jdbcexample.model.Worker;
import com.workers.jdbcexample.repository.WorkerRepository;

@RestController()
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping("/showWorker")
	public Worker showWorker() {
		return this.workerRepository.getWorker(1);
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showWorkers() {
		return this.workerRepository.getWorkers();
	}
	
	@GetMapping("/create")
	public String create() {
		this.workerRepository.add(new Worker(9, "Deepika", "Vuddagiri", 5000, Date.valueOf("2022-03-21"), "Admin","deepika.v@gmail.com"));
		return "Worker created";
	}
	
	@GetMapping("/update")
	public String update() {
		this.workerRepository.update(new Worker(9, "Deepika", "Vuddagiri", 5000, Date.valueOf("2022-03-21"), "Admin","mfs.akash@gmail.com"));
		return "Worker Updated";
	}
	
	@GetMapping("/delete")
	public String delete() {
		this.workerRepository.delete(9);
		return "Worker Deleted";
	}
}
