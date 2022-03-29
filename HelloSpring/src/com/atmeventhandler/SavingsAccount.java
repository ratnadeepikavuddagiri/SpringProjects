package com.atmeventhandler;

public class SavingsAccount extends BankAccount{

	private int accNum;
	private String accHolder;
	private double accBalance;

	public SavingsAccount(int accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double withdraw(double amount) {
		if(this.getAccBalance()<amount) 
			System.out.println("Low Balance");
		else if(amount>30000 )
			System.out.println("Withdrawl limit : 30000 ");
		else {
			this.setAccBalance(this.getAccBalance() - amount);
			return this.getAccBalance();
		}
		return -1;
	}

	@Override
	double deposit(double amount) {
		// TODO Auto-generated method stub
		if(amount>1000000)
			System.out.println("Deposit limit 1000000");
		else
			this.setAccBalance(this.getAccBalance()+amount);
		return this.getAccBalance();
	}

}
