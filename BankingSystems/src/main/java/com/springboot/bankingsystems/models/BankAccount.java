package com.springboot.bankingsystems.models;

public abstract class BankAccount {
	public Integer customerId;
	public Integer branchCode;
	public Integer accountNumber;
	public enum bankType{savings,current};
	public String type;
	public Double balance;
	
	public BankAccount() {
		
	}
	
	public BankAccount(Integer customerId, Integer branchCode,Integer accountNumber,  String type) {
		super();
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.branchCode = branchCode;
		this.type = type;
		this.balance=0.0;
	}
	
	public BankAccount(Integer customerId, Integer branchCode, Integer accountNumber, String type,Double balance) {
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.branchCode = branchCode;
		this.type = type;
		this.balance=balance;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", customerId=" + customerId + ", branchCode="
				+ branchCode + ", type=" + type + "]";
	}	
}
