package com.springboot.bankingsystems.models;

public class Admin {
	private Integer adminId;
	private String adminName;
	private Integer bankCode;
	
	public Admin() {
	}

	public Admin(Integer adminId, String adminName, Integer bankCode) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.bankCode = bankCode;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Integer getBankCode() {
		return bankCode;
	}

	public void setBankCode(Integer bankCode) {
		this.bankCode = bankCode;
	}	
}
