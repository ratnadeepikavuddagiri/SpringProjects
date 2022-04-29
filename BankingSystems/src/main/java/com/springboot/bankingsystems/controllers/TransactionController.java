package com.springboot.bankingsystems.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankingsystems.models.Branch;
import com.springboot.bankingsystems.models.Transaction;
import com.springboot.bankingsystems.services.BranchService;
import com.springboot.bankingsystems.services.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/deposit/{accountNumber}")
	public String deposit(@RequestParam Double amount,@PathVariable Integer accountNumber) {
		System.out.println(amount+" "+accountNumber);
		return this.transactionService.deposit(accountNumber,amount);
		
	}
	
	@PostMapping("/withdraw")
	public String withdraw(@RequestBody Map<String,String> requestBody) {
		return this.transactionService.withdraw(requestBody.get("accountNumber"),requestBody.get("amount"));
	}
	
	@PostMapping("/showTransactions")
	public List<Transaction> showTransactions(@RequestBody Map<String,String> requestBody){
		return this.transactionService.showTransactions(requestBody.get("start"),requestBody.get("end"));
	}
	

}
