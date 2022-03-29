package com.atmeventhandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ATMMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("ATMBean.xml");
		SavingsAccount savingsAccount = (SavingsAccount) context.getBean("savingsAccount");
		SalaryAccount salaryAccount = (SalaryAccount) context.getBean("salaryAccount");
		System.out.println("Savings Account");
		System.out.println(savingsAccount);
		System.out.println("Salary Account");
		System.out.println(salaryAccount);
		WithdrawlEventPublisher publisher = (WithdrawlEventPublisher) context.getBean("withdrawlEventPublisher");
		if(savingsAccount.withdraw(1000)!=-1)
			publisher.publish(1000,savingsAccount.getAccBalance());
		if(salaryAccount.withdraw(1000)!=-1)
			publisher.publish(1000,salaryAccount.getAccBalance());
		
	}

}
