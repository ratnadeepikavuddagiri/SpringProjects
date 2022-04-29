package com.springboot.bankingsystems.daos;

import java.sql.SQLException;
import java.util.List;

import com.springboot.bankingsystems.models.BankAccount;



public interface BankAccountDAO {
	public boolean insertBankAccount(BankAccount bankAccount,String type)
            throws SQLException;

    public boolean deleteBankAccountByAccountNumber(Integer accountNumber)
            throws SQLException;

    public BankAccount findBankAccountByAccountNumber(Integer accountNumber)
            throws SQLException;

    public List<BankAccount> findBankAccountsByCustomerId(Integer customerId)
            throws SQLException;

    public List<BankAccount> findAllBankAccounts()
            throws SQLException;
    
}
