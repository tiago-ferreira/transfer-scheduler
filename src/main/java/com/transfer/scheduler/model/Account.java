package com.transfer.scheduler.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
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
