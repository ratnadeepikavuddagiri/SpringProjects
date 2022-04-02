package com.springboot.workers.springjdbcexample.repository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.springjdbcexample.dao.WorkerDao;
import com.springboot.workers.springjdbcexample.mapper.WorkerMapper;
import com.springboot.workers.springjdbcexample.model.Worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Repository
public class WorkerRepository implements WorkerDao{
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	private static final Logger log = LoggerFactory.getLogger(WorkerRepository.class);

	
	@Override
	public int add(Worker worker) throws SQLException {
		String sql = "INSERT INTO WORKER (" +
				"worker_id,first_name, last_name,  salary,  joining_date,  department, email" +
				") VALUES (" +
				"?, ?,?,?,?,?,?" +
				")";
		int rows = jdbcTemplateObject.update(sql, worker.getWorkerId(),worker.getFirstName(), worker.getLastName(),  worker.getSalary(),  worker.getJoiningDate(),  worker.getDepartment(), worker.getEmail());
		
		System.out.println("Worker " + worker.getFirstName() + "'s record inserted successfully");
		return rows;
	}
	
	@Override
	public List<Worker> getAllWorkers() {
		String sql = "SELECT * FROM WORKER";
		List<Worker> workers = jdbcTemplateObject.query(
				sql, 
				new WorkerMapper()
				);
		
		return workers;
	}
	

	@Override
	public int delete(int workerId) throws SQLException {
		String sql = "DELETE FROM WORKER WHERE WORKER_ID = ?";
		int rows = jdbcTemplateObject.update(sql, workerId);
		System.out.println("Record #" + workerId + " deleted");
		return rows;
	}

	@Override
	public Worker getWorker(int workerId) throws SQLException {
		String sql = "SELECT * FROM WORKER WHERE WORKER_ID = ?";
		@SuppressWarnings("deprecation")
		Worker worker = jdbcTemplateObject.queryForObject(
				sql, 
				new Object[] {workerId}, 
				new WorkerMapper()
				);
		
		return worker;
	}

	@Override
	public int update(Worker emp) throws SQLException {
		String sql = "UPDATE Worker SET email = ? WHERE worker_id = ?";
		int rows = jdbcTemplateObject.update(sql, emp.getEmail(), emp.getWorkerId());
		System.out.println("Record #" + emp.getWorkerId() + "'s email updated to " + emp.getEmail());
		return rows;
	}

	
}
