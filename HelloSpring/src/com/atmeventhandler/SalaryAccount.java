package com.atmeventhandler;

public class SalaryAccount extends BankAccount {

	private int accNum;
	private String accHolder;
	private double accBalance;

	public SalaryAccount(int accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
		// TODO Auto-generated constructor stub
	}

	@Override
	double withdraw(double amount) {
		if(this.getAccBalance()<amount) 
			System.out.println("Low Balance");
		else if(amount>100000)
			System.out.println("Withdrawl limit : 100000 ");
		else {
			this.setAccBalance(this.getAccBalance() - amount);
			return this.getAccBalance();
		}
		return -1;
	}

	@Override
	double deposit(double amount) {
		// TODO Auto-generated method stub
		this.setAccBalance(this.getAccBalance()+amount);
		return this.getAccBalance();
	}
}
