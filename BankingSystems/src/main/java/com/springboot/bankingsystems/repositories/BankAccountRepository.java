package com.springboot.bankingsystems.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bankingsystems.daos.BankAccountDAO;
import com.springboot.bankingsystems.models.BankAccount;
import com.springboot.bankingsystems.models.CurrentAccount;
import com.springboot.bankingsystems.models.SavingsAccount;
import com.springboot.bankingsystems.util.DatabaseConnection;


@Repository
public class BankAccountRepository implements BankAccountDAO{
	Connection connection;
	    
    public BankAccountRepository() throws ClassNotFoundException {
	        this.connection  = DatabaseConnection.getConnection();
	    }
    

//	@Override
//	public boolean replaceBonus(Bonus bonus) throws SQLException {
//		String updateQuery = "UPDATE Bonus SET worker_Ref_id =?,Bonus_Amount = ?,bonus_Date =? WHERE worker_Ref_id = ?";
//	       PreparedStatement preparedStatement;
//		try {
//			preparedStatement = connection.prepareStatement(updateQuery);
//			preparedStatement.setInt(1, bonus.getWorkerRefId());
//			preparedStatement.setInt(2, bonus.getBonusAmount());
//			preparedStatement.setDate(3, bonus.getBonusDate());
//			int rows=preparedStatement.executeUpdate();
//			return rows>=1;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			log.error(e.toString());	}
//		return false;
//	}
	@Override
	public boolean insertBankAccount(BankAccount bankAccount,String type) throws SQLException {
		String query = "insert into bank_accounts(customer_id,branch_code,account_Number,type,balance values(?,?,?,?,? )";
	    PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, bankAccount.getCustomerId());
			ps.setInt(2, bankAccount.getBranchCode());
			ps.setInt(3, bankAccount.getAccountNumber());
			ps.setString(4, bankAccount.getType());
			ps.setDouble(5, 0.0);
			int rows =  ps.executeUpdate();
			return rows>=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deleteBankAccountByAccountNumber(Integer accountNumber) throws SQLException {
		String query = "DELETE FROM bank_accounts WHERE account_number = ?";
	    
	    PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, accountNumber);
			int rows = preparedStatement.executeUpdate();
			return rows>=1;
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return false;
	}
	@Override
	public BankAccount findBankAccountByAccountNumber(Integer accountNumber) throws SQLException {
		String query = "SELECT * FROM bank_accounts WHERE account_number=?";
	    PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, accountNumber);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
//			BankAccount ba = new SavingsAccount(rs.getInt(1), rs.getInt(2), rs.getInt(3));
//			System.out.println(ba);
			if(rs.getString(4).equals("savings"))
				return new SavingsAccount(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getString(4),rs.getDouble(5));
			else
				return new CurrentAccount(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getString(4),rs.getDouble(5));
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return null;
	}
	@Override
	public List<BankAccount> findBankAccountsByCustomerId(Integer customerId) throws SQLException {
		String query = "select * from bank_accounts where customer_id =?";
	    List<BankAccount> list = new ArrayList<>();
	    PreparedStatement preparedStatement;
	    try{
	    	preparedStatement = connection.prepareStatement(query);
	    	preparedStatement.setInt(1, customerId);
	    	ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	        	if(resultSet.getString(4).equals("savings"))
					list.add(new SavingsAccount(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),resultSet.getString(4),resultSet.getDouble(5)));
				else
					list.add(new CurrentAccount(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),resultSet.getString(4),resultSet.getDouble(5)));
	        }
	    return list;
	    } catch (SQLException e) {
			e.printStackTrace();		
	    }
	    return null;
	}
	@Override
	public List<BankAccount> findAllBankAccounts() throws SQLException {
		String query = "SELECT * FROM bank_accounts";
	    List<BankAccount> list = new ArrayList<>();
	    try (Statement statement = connection.createStatement()) {
	        ResultSet resultSet = statement.executeQuery(query);
	        while (resultSet.next()) {
	        	if(resultSet.getString(4).equals("savings")) {
					list.add(new SavingsAccount(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),resultSet.getString(4),resultSet.getDouble(5)));
	        	}
//				else
//					list.add(new CurrentAccount(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),resultSet.getString(4),resultSet.getDouble(5)));
	        }
	        return list;
	    } catch (SQLException e) {
			e.printStackTrace();		
	    }
	    return null;
	}
}
