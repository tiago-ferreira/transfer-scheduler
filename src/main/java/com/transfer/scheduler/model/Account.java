package com.transfer.scheduler.model;

public class Account {
	private String number;

	public Account() {
	}
	
	public Account(String number) {
		this.number = number;
	}
	
	public Account number(String number) {
		this.number = number;
		return this;
	}
	
	public String number() {
		return number;
	}
	
}
