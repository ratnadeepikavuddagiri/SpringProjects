package com.springboot.bankingsystems.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankingsystems.models.Bank;
import com.springboot.bankingsystems.services.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	@Autowired
	private BankService bankService;
	@GetMapping("bankCode/{bankCode}")
	public Bank showBank(@PathVariable Integer bankCode) {
		return this.bankService.showBank(bankCode);
	}
	
	@GetMapping("/all")
	public List<Bank> showBanks() {
		return this.bankService.findAllBankAccounts();
	}
	
	@GetMapping("bankName/{bankName}")
	public List<Bank> showBanksByName(@PathVariable String bankName) {
		return this.bankService.findBankByBankName(bankName);
	}
	
	@PatchMapping("/update/bankCode/{bankCode}")
	public boolean updateBank(@PathVariable int bankCode,@RequestBody Map<String,String> requestBody) {
		return this.bankService.updateBank(requestBody.get("bankCode"),requestBody.get("bankName"),requestBody.get("mainOffice"),requestBody.get("address"),bankCode);
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insertBank(@RequestBody Map<String,String> requestBody) {
		return this.bankService.addBank(requestBody.get("bankCode"),requestBody.get("bankName"),requestBody.get("mainOffice"),requestBody.get("address"));
	}

	@DeleteMapping("/delete/{bankCode}")
	public boolean deleteBank(@PathVariable int bankCode) {
		return this.bankService.deleteBank(bankCode);
	}
	
}
