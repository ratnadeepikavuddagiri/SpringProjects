package com.springboot.workers.crudapi.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;
import com.springboot.workers.crudapi.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerService workerService;
	
	@GetMapping("/id/{id}")
	public Worker showWorker(@PathVariable int id) {
		return this.workerService.getWorker(id);
	}
	
	@GetMapping("/all")
	public List<Worker> showWorkers() {
		return this.workerService.getAllWorkers();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@RequestBody Worker worker) {
		return this.workerService.createWorker(worker);	
	}
	
	@PatchMapping("/update/id/{id}")
	public boolean update(@PathVariable int id,@RequestBody Map<String,String> requestBody) {
		return this.workerService.updateWorkerEmail(id,requestBody.get("email"));
	}
	
	@GetMapping("/delete/id/{id}")
	public boolean delete(@PathVariable int id) {
		return workerService.deleteWorker(id);
	}
	@PostMapping(path = "/createWorker",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String showAuthCredentials(@RequestParam MultiValueMap<String, String> paramMap) {
		if(this.workerService.createWorker(new Worker(Integer.parseInt(paramMap.get("workerId").get(0)), paramMap.get("firstName").get(0),paramMap.get("lastName").get(0),Integer.parseInt(paramMap.get("salary").get(0)),Date.valueOf(paramMap.get("joiningDate").get(0)),paramMap.get("department").get(0),paramMap.get("email").get(0))))
				return "Worker record inserted successfully!";
		return "Worker record not inserted!";
	}
}
