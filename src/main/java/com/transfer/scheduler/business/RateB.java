package com.transfer.scheduler.business;

import java.math.BigDecimal;

import com.transfer.scheduler.exceptions.NoRateException;

public class RateB implements Rate {

	@Override
	public BigDecimal calculate(BigDecimal value, BigDecimal days)  throws NoRateException {
		return days.multiply(new BigDecimal(12));
	}

}
