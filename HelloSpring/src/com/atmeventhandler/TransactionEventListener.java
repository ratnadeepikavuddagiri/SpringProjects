package com.atmeventhandler;

import org.springframework.context.ApplicationListener;

public class TransactionEventListener implements ApplicationListener<WithdrawlEvent> {
	
	private void sendSMS() {
		
	}
	public void onApplicationEvent(WithdrawlEvent event) {
		
		System.out.println("Withdrawl Event Occured : " + event.toString());
		System.out.println("time :"+event.getTimestamp());
	}
}
