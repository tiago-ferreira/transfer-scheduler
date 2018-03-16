package com.transfer.scheduler.business;

import java.math.BigDecimal;

import com.transfer.scheduler.exceptions.NoRateException;

public class RateA implements Rate {

	@Override
	public BigDecimal calculate(BigDecimal value, BigDecimal days)  throws NoRateException{
		return percentage(value, new BigDecimal(3)).add(new BigDecimal(3));
	}

}
