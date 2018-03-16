package com.transfer.scheduler.business.test;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.transfer.scheduler.business.Rate;
import com.transfer.scheduler.business.RateA;
import com.transfer.scheduler.exceptions.NoRateException;


public class RateATest {

	private Rate rate;
	
	@BeforeEach
	public void init() {
		rate = new RateA();
	}
	
	@Test
	public void testOneHundred() throws NoRateException {
		BigDecimal value = new BigDecimal(100);
		BigDecimal expected = new BigDecimal(6);
		BigDecimal result = rate.calculate(value, BigDecimal.ZERO);
		Assertions.assertEquals(result, expected);
	}
	
	@Test
	public void testOneThousand() throws NoRateException {
		BigDecimal value = new BigDecimal(1000);
		BigDecimal expected = new BigDecimal(33);
		BigDecimal result = rate.calculate(value, BigDecimal.ZERO);
		Assertions.assertEquals(result, expected);
	}
	
	@Test
	public void testFifty() throws NoRateException {
		BigDecimal value = new BigDecimal(50);
		BigDecimal expected = new BigDecimal(4.5);
		BigDecimal result = rate.calculate(value, BigDecimal.ZERO);
		Assertions.assertEquals(result, expected);
	}

}
