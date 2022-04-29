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

import com.springboot.bankingsystems.models.Branch;
import com.springboot.bankingsystems.models.Customer;
import com.springboot.bankingsystems.services.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {
	@Autowired
	private BranchService branchService;
	
	@GetMapping("/{branchCode}")
	public Branch showBranch(@PathVariable Integer branchCode) {
		return this.branchService.findBranchbyBranchCode(branchCode);
	}
	
	@GetMapping("/all")
	public List<Branch> showBranches() {
		return this.branchService.findAllBranches();
	}
	
	@GetMapping("/showCustomers/{branchCode}/{type}")
	public List<Customer> showCustomers(@PathVariable Integer branchCode,@PathVariable String type) {
		return this.branchService.showCustomers(branchCode, type);
	}
	
//	@GetMapping("/showTransactions")
//	public List<Transaction> showTransactions() {
//		return this.branchService.showTransactions();
//	}
	
	
	@PatchMapping("/update/branchCode/{branchCode}")
	public boolean updateBranch(@PathVariable int branchCode,@RequestBody Map<String,String> requestBody) {
		return this.branchService.updateBranchByBranchCode(requestBody.get("branchCode"),requestBody.get("address"),requestBody.get("managerName"),requestBody.get("headOffice"),requestBody.get("bankCode"),branchCode);
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insertBranch(@RequestBody Map<String,String> requestBody) {
		return this.branchService.insertBranch(requestBody.get("branchCode"),requestBody.get("address"),requestBody.get("managerName"),requestBody.get("headOffice"),requestBody.get("bankCode"));
	}

	@DeleteMapping("/delete/{branchCode}")
	public boolean deleteBranch(@PathVariable int branchCode) {
		return this.branchService.deleteBranchByBranchCode(branchCode);
	}

}
