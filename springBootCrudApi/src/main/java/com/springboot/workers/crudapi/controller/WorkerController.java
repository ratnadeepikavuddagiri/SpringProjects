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

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;




@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping("/id/{id}")
	public Worker showWorker(@PathVariable int id) {
		return this.workerRepository.getWorker(id);
	}
	
	@GetMapping("/all")
	public List<Worker> showWorkers() {
		return this.workerRepository.getWorkers();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@RequestBody Worker worker) {
		return this.workerRepository.add(worker);	
	}
	
	@PatchMapping("/update/id/{id}")
	public boolean update(@PathVariable int id,@RequestBody Map<String,String> map) {
		return this.workerRepository.updateWorkerEmail(map.get("email"),id);
	}
	
	@GetMapping("/delete/id/{id}")
	public boolean delete(@PathVariable int id) {
		return workerRepository.delete(id);
	}
}
