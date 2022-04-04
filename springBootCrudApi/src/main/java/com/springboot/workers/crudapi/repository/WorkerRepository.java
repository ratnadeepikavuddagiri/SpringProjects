package com.springboot.workers.crudapi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.WorkerDao;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.util.DatabaseConnection;

@Repository
public class WorkerRepository implements WorkerDao{
	Connection connection;
	private static final Logger log = LoggerFactory.getLogger(WorkerRepository.class);

	    
    public WorkerRepository() throws ClassNotFoundException {
	        this.connection  = DatabaseConnection.getConnection();
	    }

	@Override
	public boolean insertWorker(Worker worker)  {
	    String query = "INSERT INTO Worker (WORKER_ID,FIRST_NAME,LAST_NAME,SALARY,JOINING_DATE,DEPARTMENT,email) VALUES (?,?,?,?,?,?,? )";
	    PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, worker.getWorkerId());
			ps.setString(2, worker.getFirstName());
			ps.setString(3, worker.getLastName());
			ps.setInt(4, worker.getSalary());
			ps.setDate(5, worker.getJoiningDate());
			ps.setString(6, worker.getDepartment());
			ps.setString(7, worker.getEmail());
			int rows =  ps.executeUpdate();
			return rows>=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		}
		return false;
	}

	@Override
	public boolean deleteWorker(int workerId)  {
	    String query = "DELETE FROM Worker WHERE WORKER_ID = ?";
	    
	    PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, workerId);
			int rows = preparedStatement.executeUpdate();
			return rows>=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());		}
		return false;
	}

	@Override
	public Worker findWorkerById(int workerId)  {
	    String query = "SELECT * FROM WORKER WHERE WORKER_ID=?";
	    PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, workerId);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			return new Worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6),
					rs.getString(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());		}
		return null;
	}

	@Override
	public List<Worker> findWorkers() {
	    String query = "SELECT * FROM worker";
	    List<Worker> list = new ArrayList<>();
	    try (Statement statement = connection.createStatement()) {
	        ResultSet resultSet = statement.executeQuery(query);
	        while (resultSet.next()) {
	            list.add(new Worker(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getDate(5),
	                    resultSet.getString(6),
	                    resultSet.getString(7)));
	        }
	    return list;
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
	    	log.error(e.toString());		}
	    return null;
	}

	@Override
	public boolean replaceWorker(Worker emp)  {
	    // TODO Auto-generated method stub
	   String updateQuery = "UPDATE Worker SET worker_id =?,first_name = ?,last_name =?,salary =?,joining_date = ?,department = ?,email = ? WHERE worker_id = ?";
       PreparedStatement preparedStatement;
	try {
		preparedStatement = connection.prepareStatement(updateQuery);
		preparedStatement.setInt(1, emp.getWorkerId());
		preparedStatement.setString(2, emp.getFirstName());
		preparedStatement.setString(3, emp.getLastName());
		preparedStatement.setInt(4, emp.getSalary());
		preparedStatement.setDate(5, emp.getJoiningDate());
		preparedStatement.setString(6, emp.getDepartment());
		preparedStatement.setString(7, emp.getEmail());
		preparedStatement.setInt(8, emp.getWorkerId());
		int rows=preparedStatement.executeUpdate();
		return rows>=1;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		log.error(e.toString());	}
	return false;
    }

	@Override
	public boolean updateWorkerEmailById(String email,int workerId) {
		try {
			String updateQuery = "UPDATE Worker SET email = ? WHERE worker_id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, workerId);
			int rows =preparedStatement.executeUpdate();
			return (rows>=1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
