package com.springboot.workers.crudapi.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;

@Service
public class WorkerService {
	@Autowired
	private WorkerRepository workerRepository;
	
	public Worker getWorker(Integer id) {
		try {
			return this.workerRepository.findWorkerById(id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			}
		return null;
	}
	
	public List<Worker> getAllWorkers() {
		try {
			return this.workerRepository.findWorkers();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public boolean createWorker(Worker worker) {
		try {
			return this.workerRepository.insertWorker(worker);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean updateWorkerEmail(Integer id,String email) {
		try {
			return this.workerRepository.updateWorkerEmailById(email,id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean deleteWorker(Integer id) {
		try {
			return workerRepository.deleteWorker(id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
