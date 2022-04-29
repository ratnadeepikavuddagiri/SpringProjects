package com.springboot.bankingsystems.models;

public class CurrentAccount extends BankAccount{
	private Integer accountNumber;
	private Integer customerId;
	private Integer branchCode;
	private String type;
	private Double balance;
	
	public CurrentAccount(Integer customerId, Integer branchCode,Integer accountNumber,String type, Double balance) {
		super(customerId, branchCode,accountNumber,type,balance);
		this.balance=balance;
	}

	@Override
	public String toString() {
		return "CurrentAccount [accountNumber=" + accountNumber + ", customerId=" + customerId + ", branchCode="
				+ branchCode + ", type=" + type + "]";
	}
	
	

}
