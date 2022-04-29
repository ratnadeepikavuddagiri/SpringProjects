package com.springboot.bankingsystems.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankingsystems.models.BankAccount;
import com.springboot.bankingsystems.repositories.BankAccountRepository;


@Service
public class BankAccountService {
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	public boolean addBankAccount(BankAccount bankAccount, String type)  {
		try {
			return this.bankAccountRepository.insertBankAccount(bankAccount, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean deleteBankAccountByAccountNumber(Integer accountNumber) {
		try {
			return this.bankAccountRepository.deleteBankAccountByAccountNumber(accountNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public BankAccount showBankAccountByAccountNumber(Integer accountNumber)  {
		try {
			return this.bankAccountRepository.findBankAccountByAccountNumber(accountNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<BankAccount> findBankAccountsByCustomerId(Integer customerId)  {
		try {
			return this.bankAccountRepository.findBankAccountsByCustomerId(customerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<BankAccount> findAllBankAccounts() {
		try {
			return this.bankAccountRepository.findAllBankAccounts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
