package com.springboot.bankingsystems.services;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankingsystems.daos.BranchDAO;
import com.springboot.bankingsystems.models.Branch;
import com.springboot.bankingsystems.models.Customer;
import com.springboot.bankingsystems.models.Transaction;
import com.springboot.bankingsystems.repositories.BranchRepository;

@Service
public class BranchService  {
	@Autowired
	private BranchRepository branchRepository;


	public boolean deleteBranchByBranchCode(Integer branchCode){
		try {
			return this.branchRepository.deleteBranchByBranchCode(branchCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public Branch findBranchbyBranchCode(Integer branchCode)  {
		try {
			return this.branchRepository.findBranchbyBranchCode(branchCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public List<Branch> findAllBranches()  {
		try {
			return this.branchRepository.findAllBranches();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	
	public List<Transaction> showTransactions(Date start, Date end) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Customer> showCustomers(Integer branchCode, String type) {
		try {
			return this.branchRepository.showCustomers(branchCode, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateBranchByBranchCode(String newbranchCode, String address,String managerName,String headOffice,String bankCode,
			int oldbranchCode) {
		try {
			return this.branchRepository.updateBranchByBranchCode(new Branch(Integer.parseInt(newbranchCode),address,managerName,headOffice,Integer.parseInt(bankCode)), oldbranchCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertBranch(String newbranchCode, String address,String managerName,String headOffice,String bankCode) {
		try {
			return this.branchRepository.insertBranch(new Branch(Integer.parseInt(newbranchCode),address,managerName,headOffice,Integer.parseInt(bankCode)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
