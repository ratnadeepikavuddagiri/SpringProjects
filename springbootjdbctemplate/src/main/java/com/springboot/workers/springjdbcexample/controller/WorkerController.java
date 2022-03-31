package com.springboot.workers.springjdbcexample.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.springjdbcexample.model.Worker;
import com.springboot.workers.springjdbcexample.repository.WorkerRepository;


@RestController()
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping("/showWorker")
	public Worker showWorker() throws SQLException {
		return this.workerRepository.getWorker(1);
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showWorkers() {
		return this.workerRepository.getAllWorkers();
	}
	
	@GetMapping("/create")
	public String create() throws SQLException {
		this.workerRepository.add(new Worker(9, "Deepika", "Vuddagiri", 5000, Date.valueOf("2022-03-21"), "Admin","deepika.v@gmail.com"));
		return "Worker created";
	}
	
	@GetMapping("/update")
	public String update() throws SQLException {
		this.workerRepository.update(new Worker(9, "Deepika", "Vuddagiri", 5000, Date.valueOf("2022-03-21"), "Admin","mfs.akash@gmail.com"));
		return "Worker Updated";
	}
	
	@GetMapping("/delete")
	public String delete() throws SQLException {
		this.workerRepository.delete(9);
		return "Worker Deleted";
	}
}

