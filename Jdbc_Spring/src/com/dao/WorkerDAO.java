package com.dao;

import java.sql.Date;
import java.util.List;
import javax.sql.DataSource;
import com.models.Worker;

public interface WorkerDAO {
	public void setDataSource(DataSource dataSource);
	public void create(int workerId, String firstName, String lastName, int salary, Date joiningDate, String department,
            String email);
	public Worker getWorkerById(Integer workerId);
	public List<Worker> getAllWorkers();
	public void delete(Integer workerId);
	
}
