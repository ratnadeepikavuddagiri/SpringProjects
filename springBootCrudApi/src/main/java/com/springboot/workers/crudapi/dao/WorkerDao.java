package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudapi.model.Worker;

public interface WorkerDao {
	public boolean insertWorker(Worker worker)
            throws SQLException;

    public boolean deleteWorker(int workerId)
            throws SQLException;

    public Worker findWorkerById(int workerId)
            throws SQLException;

    public List<Worker> findWorkers()
            throws SQLException;

    public boolean replaceWorker(Worker emp)
            throws SQLException;
    

	boolean updateWorkerEmailById(String email, int worker_id)
			throws SQLException;
}
