package com.springboot.bankingsystems.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bankingsystems.daos.TransactionDAO;
import com.springboot.bankingsystems.models.Bank;
import com.springboot.bankingsystems.models.SavingsAccount;
import com.springboot.bankingsystems.models.Transaction;
import com.springboot.bankingsystems.util.CurrentTimestamp;
import com.springboot.bankingsystems.util.DatabaseConnection;

@Repository
public class TransactionRepository implements TransactionDAO{

	Connection connection;
    
    public TransactionRepository() throws ClassNotFoundException {
	        this.connection  = DatabaseConnection.getConnection();
	}
	@Override
	public boolean deposit(Integer accountNumber, Double amount) throws SQLException {
		String query = "select balance,branch_code FROM bank_accounts WHERE account_number = ?";
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, accountNumber);
			resultSet= preparedStatement.executeQuery();
			resultSet.next();
			Double balance = resultSet.getDouble(1);
			Integer branchCode =resultSet.getInt(2);
			String update = "update bank_accounts set balance = ? where account_number=?";
			preparedStatement = connection.prepareStatement(update);
			preparedStatement.setDouble(1, balance+amount);
			preparedStatement.setInt(2, accountNumber);
			int r1 = preparedStatement.executeUpdate();
			String insert = "insert into transactions(account_number,amount,type,timestamp,branch_code) values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, accountNumber);
			preparedStatement.setDouble(2, amount);
			preparedStatement.setString(3, "credit");
			preparedStatement.setTimestamp(4,CurrentTimestamp.getCurrentTimeStamp());
			preparedStatement.setInt(5, branchCode);
			int r2=preparedStatement.executeUpdate();
			return (r1>=1&&r2>=1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return false;
	}

	@Override
	public boolean withdraw(Integer accountNumber, Double amount) throws SQLException {
		String query = "select balance,branch_code FROM bank_accounts WHERE account_number = ?";
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, accountNumber);
			resultSet= preparedStatement.executeQuery();
			resultSet.next();
			Double balance = resultSet.getDouble(1);
			Integer branchCode = resultSet.getInt(2);
			if(SavingsAccount.withdraw(amount, balance)) {
				String update = "update bank_accounts set balance = ? where account_number=?";
				preparedStatement = connection.prepareStatement(update);
				preparedStatement.setDouble(1, balance-amount);
				preparedStatement.setInt(2, accountNumber);
				int r1=preparedStatement.executeUpdate();
				String insert = "insert into transactions(account_number,amount,type,timestamp,branch_code) values(?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(insert);
				preparedStatement.setInt(1, accountNumber);
				preparedStatement.setDouble(2, amount);
				preparedStatement.setString(3, "debit");
				preparedStatement.setTimestamp(4,CurrentTimestamp.getCurrentTimeStamp());
				preparedStatement.setInt(5, branchCode);
				int r2=preparedStatement.executeUpdate();
				return (r1>=1&& r2>=1);
			}
			else 
				System.out.println("Not possible!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return false;
	}

	@Override
	public boolean deleteTransaction(Integer transactionNumber) throws SQLException {
		String query = "DELETE FROM Transactions WHERE transaction_number = ?";
	    
	    PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, transactionNumber);
			int rows = preparedStatement.executeUpdate();
			return rows>=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return false;	
	}
	public List<Transaction> showTransactions(Timestamp start,Timestamp end) {
		String query = "select * from transactions where timestamp";
	    List<Transaction> list = new ArrayList<>();
	    try {
	    	PreparedStatement stmt = connection.prepareStatement("SELECT * FROM transactions WHERE timestamp BETWEEN ? AND ?"); 
	    	stmt.setTimestamp(1, start);
	    	stmt.setTimestamp(2, end);
	        ResultSet resultSet = stmt.executeQuery(query);
	        while (resultSet.next())
					list.add(new Transaction(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDouble(3),resultSet.getString(4),resultSet.getTimestamp(5),resultSet.getInt(6)));
	    return list;
	    } catch (SQLException e) {
			e.printStackTrace();		
	    }
	    return null;
	}

}
