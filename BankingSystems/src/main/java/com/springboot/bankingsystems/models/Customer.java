package com.springboot.bankingsystems.models;

import java.util.Objects;

public class Customer {
	private String customerName;
	private String address;
	private Integer customerId;
	
	public Customer() {
		
	}

	public Customer(Integer customerId,String customerName, String address) {
		super();
		this.customerName = customerName;
		this.address = address;
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerId, other.customerId);
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", address=" + address + ", customerId=" + customerId + "]";
	}
	
}
