package com.springboot.bankingsystems.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankingsystems.models.Bank;
import com.springboot.bankingsystems.repositories.BankRepository;

@Service
public class BankService {
	@Autowired
	private BankRepository bankRepository;
	
	public boolean addBank(String bankCode, String bankName, String mainOffice, String address)  {
		try {
			return this.bankRepository.insertBank(new Bank(Integer.parseInt(bankCode),bankName,Boolean.parseBoolean(mainOffice),address));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean deleteBank(Integer bankCode) {
		try {
			return this.bankRepository.deleteBankByBankCode(bankCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public Bank showBank(Integer bankCode)  {
		try {
			return this.bankRepository.findBankbyBankCode(bankCode) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<Bank> findBankByBankName(String bankName)  {
		try {
			return this.bankRepository.findBanksByBankName(bankName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<Bank> findAllBankAccounts() {
		try {
			return this.bankRepository.findAllBanks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public boolean updateBank(String newBankCode, String bankName, String mainOffice, String address,Integer oldBankCode) {
		try {
			return this.bankRepository.updateBankByBankCode(new Bank(Integer.parseInt(newBankCode),bankName,Boolean.parseBoolean(mainOffice),address),oldBankCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



}
