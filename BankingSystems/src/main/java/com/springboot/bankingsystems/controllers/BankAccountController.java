package com.springboot.bankingsystems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankingsystems.models.BankAccount;
import com.springboot.bankingsystems.services.BankAccountService;


@RestController
@RequestMapping("/employee")
public class BankAccountController {
	@Autowired
	private BankAccountService bankAccountService;
	
	@GetMapping("/showBankAccounts/all")
	public List<BankAccount> showBonus(){
		return this.bankAccountService.findAllBankAccounts();
	}
	@GetMapping("/id/{id}")
	public BankAccount showCustomer(@PathVariable int id){
		return this.bankAccountService.showBankAccountByAccountNumber(id);
		}
}
