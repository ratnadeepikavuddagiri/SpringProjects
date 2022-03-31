package com.springboot.workers.springjdbcexample.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.springjdbcexample.model.Worker;

public interface WorkerDao {
		public int add(Worker worker)
	            throws SQLException;

	    public int delete(int workerId)
	            throws SQLException;

	    public Worker getWorker(int workerId)
	            throws SQLException;

	    public List<Worker> getAllWorkers()
	            throws SQLException;

	    public int update(Worker emp)
	            throws SQLException;
}
