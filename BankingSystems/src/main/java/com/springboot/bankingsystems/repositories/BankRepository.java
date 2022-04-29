package com.springboot.bankingsystems.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bankingsystems.daos.BankDAO;
import com.springboot.bankingsystems.models.Bank;
import com.springboot.bankingsystems.util.DatabaseConnection;

@Repository
public class BankRepository implements BankDAO{
	Connection connection;
    
    public BankRepository() throws ClassNotFoundException {
	        this.connection  = DatabaseConnection.getConnection();
	    }
    
	@Override
	public boolean insertBank(Bank bank) throws SQLException {
		String query = "insert into banks(bank_code,bank_name,main_office,address) values(?,?,?,?)";
	    PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, bank.getBankCode() );
			ps.setString(2, bank.getBankName() );
			ps.setBoolean(3, bank.getMainOffice() );
			ps.setString(4,bank.getAddress());
			int rows =  ps.executeUpdate();
			return rows>=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBankByBankCode(Integer bankCode) throws SQLException {
		String query = "DELETE FROM banks WHERE bank_code = ?";
	    
	    PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bankCode);
			int rows = preparedStatement.executeUpdate();
			return rows>=1;
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return false;
	}

	@Override
	public Bank findBankbyBankCode(Integer bankCode) throws SQLException {
		String query = "SELECT * FROM banks WHERE bank_code=?";
	    PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bankCode);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
				return new Bank(rs.getInt(1), rs.getString(2), rs.getBoolean(3),rs.getString(4));	
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return null;
	}

	@Override
	public List<Bank> findBanksByBankName(String bankName) throws SQLException {
		String query = "select * from banks where bank_name =?";
	    List<Bank> list = new ArrayList<>();
	    PreparedStatement preparedStatement;
	    try{
	    	preparedStatement = connection.prepareStatement(query);
	    	preparedStatement.setString(1, bankName);
	    	ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next())
					list.add(new Bank(resultSet.getInt(1), resultSet.getString(2), resultSet.getBoolean(3),resultSet.getString(4)));
	    return list;
	    } catch (SQLException e) {
			e.printStackTrace();		
	    }
	    return null;
	}

	@Override
	public List<Bank> findAllBanks() throws SQLException {
		String query = "select * from banks";
	    List<Bank> list = new ArrayList<>();
	    try (Statement statement = connection.createStatement()) {
	        ResultSet resultSet = statement.executeQuery(query);
	        while (resultSet.next())
					list.add(new Bank(resultSet.getInt(1), resultSet.getString(2), resultSet.getBoolean(3),resultSet.getString(4)));
	    return list;
	    } catch (SQLException e) {
			e.printStackTrace();		
	    }
	    return null;
	}

	@Override
	public boolean updateBankByBankCode(Bank bank,Integer bankCode) throws SQLException {
		String updateQuery = "UPDATE Banks SET bank_code =?,bank_name=?,main_office=?,address=? WHERE bank_code = ?";
	       PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setInt(1, bank.getBankCode() );
			preparedStatement.setString(2, bank.getBankName());
			preparedStatement.setBoolean(3, bank.getMainOffice());
			preparedStatement.setString(4, bank.getAddress());
			preparedStatement.setInt(5, bankCode);
			int rows=preparedStatement.executeUpdate();
			return rows>=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
