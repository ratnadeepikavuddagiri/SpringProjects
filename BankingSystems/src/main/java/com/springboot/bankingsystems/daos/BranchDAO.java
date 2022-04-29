package com.springboot.bankingsystems.daos;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.springboot.bankingsystems.models.BankAccount;
import com.springboot.bankingsystems.models.Branch;
import com.springboot.bankingsystems.models.Customer;
import com.springboot.bankingsystems.models.Transaction;


public interface BranchDAO {
	public boolean insertBranch(Branch branch)
            throws SQLException;

    public boolean deleteBranchByBranchCode(Integer branchCode)
            throws SQLException;

    public Branch findBranchbyBranchCode(Integer branchCode)
            throws SQLException;

    public List<Branch> findAllBranches()
            throws SQLException;
   

	public boolean updateBranchByBranchCode(Branch branch, Integer branchCode) 
			throws SQLException;
	
	public List<Transaction> showTransactions(Date start,Date end)
            throws SQLException;

	public List<Customer> showCustomers(Integer branchCode, String type) throws SQLException;

}
