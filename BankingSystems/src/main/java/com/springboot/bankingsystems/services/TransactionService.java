package com.springboot.bankingsystems.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankingsystems.models.Transaction;
import com.springboot.bankingsystems.repositories.TransactionRepository;
import com.springboot.bankingsystems.util.CurrentTimestamp;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	public String deposit(Integer accountNumber, Double amount) {
		try {
			if(this.transactionRepository.deposit(accountNumber, amount)) {
				System.out.println("true");
				return "Transaction Successful!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Transaction Unsuccessful!";
	}

	public String withdraw(String accountNumber, String amount) {
		try {
		if(this.transactionRepository.withdraw(Integer.parseInt(accountNumber), Double.parseDouble(amount)))
				return "Transaction Successful!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Transaction Unsuccessful!";
		
	}

	public List<Transaction> showTransactions(String start, String end) {
		
		return this.transactionRepository.showTransactions(CurrentTimestamp.getTimestamp(start),CurrentTimestamp.getTimestamp(end));
	}
	
	
}
