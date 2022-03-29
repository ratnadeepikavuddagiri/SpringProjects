package com.services;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.WorkerDAO;
import com.mappers.WorkerMapper;
import com.models.Worker;

public class WorkerJdbcTemplate implements WorkerDAO{
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(int workerId, String firstName, String lastName, int salary, Date joiningDate, String department,
            String email) {
		String sql = "INSERT INTO WORKER (" +
				"worker_id,first_name, last_name,  salary,  joining_date,  department, email" +
				") VALUES (" +
				"?, ?,?,?,?,?,?" +
				")";
		
		jdbcTemplateObject.update(sql, workerId,firstName, lastName,  salary,  joiningDate,  department, email);
		
		System.out.println("Worker " + firstName + "'s record inserted successfully");
		return;
	}
	
	public Worker getWorkerById(Integer workerId) {
		String sql = "SELECT * FROM WORKER WHERE WORKER_ID = ?";
		Worker worker = jdbcTemplateObject.queryForObject(
				sql, 
				new Object[] {workerId}, 
				new WorkerMapper()
				);
		
		return worker;
	}
	
	public List<Worker> getAllWorkers() {
		String sql = "SELECT * FROM WORKER";
		List<Worker> workers = jdbcTemplateObject.query(
				sql, 
				new WorkerMapper()
				);
		
		return workers;
	}
	
	public void update(Integer workerId, Integer salary) {
		String sql = "UPDATE Worker SET salary = ? WHERE worker_id = ?";
		jdbcTemplateObject.update(sql, salary, workerId);
		System.out.println("Record #" + workerId + "'s salary updated to " + salary);
		return;
	}
	
	public void delete(Integer workerId) {
		String sql = "DELETE FROM WORKER WHERE WORKER_ID = ?";
		jdbcTemplateObject.update(sql, workerId);
		System.out.println("Record #" + workerId + " deleted");
		return;
	}

}
