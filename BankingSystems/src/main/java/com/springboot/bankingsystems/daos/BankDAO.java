package com.springboot.bankingsystems.daos;

import java.sql.SQLException;
import java.util.List;

import com.springboot.bankingsystems.models.Bank;

public interface BankDAO {
	public boolean insertBank(Bank bank)
            throws SQLException;

    public boolean deleteBankByBankCode(Integer bankCode)
            throws SQLException;

    public Bank findBankbyBankCode(Integer bankCode)
            throws SQLException;

    public List<Bank> findBanksByBankName(String bankName)
            throws SQLException;

    public List<Bank> findAllBanks()
            throws SQLException;
   

	public boolean updateBankByBankCode(Bank bank, Integer bankCode) throws SQLException;

}
