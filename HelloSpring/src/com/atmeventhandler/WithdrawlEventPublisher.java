package com.atmeventhandler;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class WithdrawlEventPublisher implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		this.publisher = publisher;
	}	
	
	public void publish(double amount,double balance) {
		WithdrawlEvent event = new WithdrawlEvent(this,amount,balance);
		this.publisher.publishEvent(event);
	}
}
