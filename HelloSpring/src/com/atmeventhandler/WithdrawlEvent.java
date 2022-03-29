package com.atmeventhandler;

import org.springframework.context.ApplicationEvent;

public class WithdrawlEvent extends ApplicationEvent {
	final double amount,balance;
		public WithdrawlEvent(Object source,double amount,double balance) {
			super(source);
			this.amount=amount;
			this.balance=balance;
		}
		
		public String toString() {
			return "\nAmount Withdrawn : "+this.amount+"\nBalance : "+this.balance;
		}
}
