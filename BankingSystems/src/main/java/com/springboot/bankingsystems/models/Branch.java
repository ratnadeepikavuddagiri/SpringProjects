package com.springboot.bankingsystems.models;

public class Branch {
	private Integer branchCode;
	private Integer bankCode;
	private String managerName;
	private String address;
	private String headOffice;
	
	public Branch(Integer branchCode, String address, String managerName, String headOffice,Integer bankCode) {
		super();
		this.branchCode = branchCode;
		this.bankCode = bankCode;
		this.managerName = managerName;
		this.address = address;
		this.headOffice = headOffice;
	}

	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	public Integer getBankCode() {
		return bankCode;
	}

	public void setBankCode(Integer bankCode) {
		this.bankCode = bankCode;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHeadOffice() {
		return headOffice;
	}

	public void setHeadOffice(String headOffice) {
		this.headOffice = headOffice;
	}

	@Override
	public String toString() {
		return "Branch [branchCode=" + branchCode + ", bankCode=" + bankCode + ", managerName=" + managerName
				+ ", address=" + address + ", headOffice=" + headOffice + "]";
	}
	
	
}
