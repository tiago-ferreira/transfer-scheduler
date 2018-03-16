package com.transfer.scheduler.business;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.transfer.scheduler.exceptions.NoRateException;

@Component
public class RateContext {

	private Rate rate;
	
	public void setRateContext(Rate rate) {
		this.rate = rate;
	}
	
	public BigDecimal calculateRate(BigDecimal value, BigDecimal days) throws NoRateException {
		return rate.calculate(value, days);
	}
	
	
}
