package com.springboot.bankingsystems.models;

public class SavingsAccount extends BankAccount {

	private Integer accountNumber;
	private Integer customerId;
	private Integer branchCode;
	private String type;
	private Double balance;
	
	public SavingsAccount(Integer customerId,Integer branchCode,Integer accountNumber,String type,Double balance) {
		super(customerId, branchCode,accountNumber, type);
		this.balance=balance;
	}

	@Override
	public String toString() {
		return "SavingsAccount [accountNumber=" + accountNumber + ", customerId=" + customerId + ", branchCode="
				+ branchCode + ", type=" + type + "]";
	}
	public static Boolean withdraw(Double amount,Double balance) {
		if(balance<amount)
			return false;
		return true;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
