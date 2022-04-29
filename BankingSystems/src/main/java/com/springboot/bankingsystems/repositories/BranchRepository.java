package com.springboot.bankingsystems.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bankingsystems.daos.BranchDAO;
import com.springboot.bankingsystems.models.Branch;
import com.springboot.bankingsystems.models.Customer;
import com.springboot.bankingsystems.models.Transaction;
import com.springboot.bankingsystems.util.DatabaseConnection;

@Repository
public class BranchRepository implements BranchDAO{
	Connection connection;
    
    public BranchRepository() throws ClassNotFoundException {
	        this.connection  = DatabaseConnection.getConnection();
	}

	@Override
	public boolean insertBranch(Branch branch) throws SQLException {
		String query = "INSERT INTO Branches (branch_code,address,manager_name,head_office,bank_code) VALUES (?,?,?,?,? )";
	    PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, branch.getBranchCode());
			ps.setString(2, branch.getAddress());
			ps.setString(3, branch.getManagerName());
			ps.setString(4, branch.getHeadOffice());
			ps.setInt(5, branch.getBankCode());
			int rows =  ps.executeUpdate();
			return rows>=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBranchByBranchCode(Integer branchCode) throws SQLException {
		String query = "DELETE FROM Branches WHERE branch_code = ?";
	    
	    PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, branchCode);
			int rows = preparedStatement.executeUpdate();
			return rows>=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return false;
	}

	@Override
	public Branch findBranchbyBranchCode(Integer branchCode) throws SQLException {
		String query = "SELECT * FROM Branches WHERE branch_code=?";
	    PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, branchCode);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			return new Branch(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5));
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return null;
	}

	@Override
	public List<Branch> findAllBranches() throws SQLException {
		String query = "SELECT * FROM branches";
	    List<Branch> list = new ArrayList<>();
	    try (Statement statement = connection.createStatement()) {
	        ResultSet resultSet = statement.executeQuery(query);
	        while (resultSet.next()) 
	            list.add(new Branch(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5)));
	    return list;
	    } catch (SQLException e) {
			e.printStackTrace();		
	    }
	    return null;
	}

	@Override
	public boolean updateBranchByBranchCode(Branch branch, Integer branchCode) throws SQLException {
		String updateQuery = "UPDATE Branches SET branch_code =?,address = ?,manager_name =?,head_office=?,bank_code=? WHERE branch_code =?";
	       PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setInt(1, branch.getBranchCode());
			preparedStatement.setString(2, branch.getAddress());
			preparedStatement.setString(3, branch.getManagerName());
			preparedStatement.setString(4, branch.getHeadOffice());
			preparedStatement.setInt(5, branch.getBankCode());
			int rows=preparedStatement.executeUpdate();
			preparedStatement.setInt(6, branchCode);
			return rows>=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Transaction> showTransactions(Date start, Date end) throws SQLException {
		
		return null;
	}

	@Override
	public List<Customer> showCustomers(Integer branchCode,String type) throws SQLException {
		String query ="select * from customers where customer_id in(select customer_id from bank_accounts where branch_code=? and type=?)";
		List<Customer> list = new ArrayList<>();
		PreparedStatement preparedStatement;
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, branchCode);
			preparedStatement.setString(2, type);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) 
	            list.add(new Customer(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3)));
	    return list;
	    } catch (SQLException e) {
			e.printStackTrace();		
	    }
		return null;
	}
    
    
}
