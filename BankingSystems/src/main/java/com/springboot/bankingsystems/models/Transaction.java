package com.springboot.bankingsystems.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Transaction {
	private Integer accountNumber;
	public enum transactionType{credit,debit};
	private String type;
	private Timestamp timestamp;
	private Double amount;
	private Integer transactionNumber;
	private Integer branchCode;
	
	public Transaction() {
	}

	public Transaction(Integer transactionNumber,Integer accountNumber,Double amount,String type, Timestamp timestamp,  Integer branchCode) {
		super();
		this.accountNumber = accountNumber;
		this.timestamp = timestamp;
		this.amount = amount;
		this.transactionNumber = transactionNumber;
		this.branchCode =branchCode;
		this.type=type;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(Integer transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	

	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, transactionNumber);
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(accountNumber, other.accountNumber)
				&& Objects.equals(transactionNumber, other.transactionNumber);
	}

	@Override
	public String toString() {
		return "Transaction [accountNumber=" + accountNumber + ", timestamp=" + timestamp + ", amount=" + amount
				+ ", transactionNumber=" + transactionNumber + "]";
	}
	
	
}
