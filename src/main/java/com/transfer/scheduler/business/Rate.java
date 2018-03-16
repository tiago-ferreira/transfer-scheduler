package com.transfer.scheduler.business;

import java.math.BigDecimal;

import com.transfer.scheduler.exceptions.NoRateException;

public interface Rate {
	
	BigDecimal calculate(BigDecimal value, BigDecimal days) throws NoRateException;
	
	default BigDecimal percentage(BigDecimal value, BigDecimal percentage) {
		return value.multiply(percentage).divide(new BigDecimal(100));
	}
}
