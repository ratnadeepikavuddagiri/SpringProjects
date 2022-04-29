package com.springboot.bankingsystems.models;

public class Bank {
	private Integer bankCode;
	private String bankName;
	private Boolean mainOffice;
	private String address;
	public Bank(Integer bankCode, String bankName, Boolean mainOffice, String address) {
		super();
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.mainOffice = mainOffice;
		this.address = address;
	}
	public Integer getBankCode() {
		return bankCode;
	}
	public void setBankCode(Integer bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Boolean getMainOffice() {
		return mainOffice;
	}
	public void setMainOffice(Boolean mainOffice) {
		this.mainOffice = mainOffice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Bank [bankCode=" + bankCode + ", bankName=" + bankName + ", mainOffice=" + mainOffice + ", address="
				+ address + "]";
	}

}
