package com.transfer.scheduler.exceptions;

import java.math.BigDecimal;

public class NoRateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal value;
	private Integer days;
	
	public NoRateException(BigDecimal value, Integer days) {
		super(String.format("Unable to calculate the rate for the value: $ %s, and the number of days: %d for the transfer ", value.toString(), days));
		this.value = value;
		this.days = days;
	}
	
	public BigDecimal getValue() {
		return value;
	}
	
	public Integer getDays() {
		return days;
	}
	
}
