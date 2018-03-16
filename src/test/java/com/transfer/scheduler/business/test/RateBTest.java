package com.transfer.scheduler.business.test;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.transfer.scheduler.business.Rate;
import com.transfer.scheduler.business.RateB;
import com.transfer.scheduler.exceptions.NoRateException;

class RateBTest {

	private Rate rate;
	
	@BeforeEach
	public void init() {
		rate = new RateB();
	}
	
	@Test
	public void testThreeDays() throws NoRateException {
		BigDecimal value = new BigDecimal(100);
		BigDecimal days = new BigDecimal(3);
		BigDecimal expected = new BigDecimal(36);
		BigDecimal result = rate.calculate(value, days);
		Assertions.assertEquals(result, expected);
	}
	
	@Test
	public void testFiveDays() throws NoRateException {
		BigDecimal value = new BigDecimal(1000);
		BigDecimal days = new BigDecimal(5);
		BigDecimal expected = new BigDecimal(60);
		BigDecimal result = rate.calculate(value, days);
		Assertions.assertEquals(result, expected);
	}
	
	@Test
	public void testNineDays() throws NoRateException {
		BigDecimal value = new BigDecimal(50);
		BigDecimal days = new BigDecimal(9);
		BigDecimal expected = new BigDecimal(108);
		BigDecimal result = rate.calculate(value, days);
		Assertions.assertEquals(result, expected);
	}

}
