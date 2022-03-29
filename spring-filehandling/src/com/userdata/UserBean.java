package com.userdata;

public class UserBean {
	String firstName;
	String lastName;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static UserBean getInstance() {
		return new UserBean();
	}
	@Override
	public String toString() {
		return "MyBean [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
