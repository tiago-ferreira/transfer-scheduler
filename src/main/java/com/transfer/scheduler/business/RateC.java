package com.transfer.scheduler.business;

import java.math.BigDecimal;

import com.transfer.scheduler.exceptions.NoRateException;

public class RateC implements Rate{

	@Override
	public BigDecimal calculate(BigDecimal value, BigDecimal days) throws NoRateException  {
		Integer day = days.intValue();
		if( day < 21) {
			return percentage(value, new BigDecimal(8));
		} else if(day < 31) {
			return percentage(value, new BigDecimal(6));
		} else if(day < 41) {
			return percentage(value, new BigDecimal(4));
		} else if(value.compareTo(new BigDecimal(100000)) == 1) {
			return percentage(value, new BigDecimal(2));
		} else {
			throw new NoRateException(value, day);
		}
	}
	
	public boolean greatherThan(BigDecimal value1, BigDecimal value2) {
		return value1.compareTo(value2) == 1;
	}

}
