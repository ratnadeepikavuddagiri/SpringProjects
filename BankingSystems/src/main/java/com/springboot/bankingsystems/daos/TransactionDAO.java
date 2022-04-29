package com.springboot.bankingsystems.daos;

import java.sql.SQLException;
import java.util.List;

import com.springboot.bankingsystems.models.Transaction;


public interface TransactionDAO {
	public boolean deposit(Integer accountNumber,Double amount)
            throws SQLException;

	public boolean withdraw(Integer accountNumber,Double amount)
            throws SQLException;

	public boolean deleteTransaction(Integer transactionId)
            throws SQLException;

    
}
