package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudapi.model.Worker;

public interface WorkerDao {
	public boolean add(Worker worker)
            throws SQLException;

    public boolean delete(int workerId)
            throws SQLException;

    public Worker getWorker(int workerId)
            throws SQLException;

    public List<Worker> getWorkers()
            throws SQLException;

    public boolean replace(Worker emp)
            throws SQLException;
    

	boolean updateWorkerEmail(String email, int worker_id)
			throws SQLException;
}
