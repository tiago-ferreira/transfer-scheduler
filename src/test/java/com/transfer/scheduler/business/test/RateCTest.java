package com.transfer.scheduler.business.test;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.transfer.scheduler.business.Rate;
import com.transfer.scheduler.business.RateC;
import com.transfer.scheduler.exceptions.NoRateException;

class RateCTest {

	private Rate rate;
	
	@BeforeEach
	public void init() {
		rate = new RateC();
	}
	
	
	@Test
	public void testElevenDays() throws NoRateException {
		BigDecimal value = new BigDecimal(100);
		BigDecimal days = new BigDecimal(11);
		BigDecimal expected = new BigDecimal(8);
		BigDecimal result = rate.calculate(value, days);
		Assertions.assertEquals(result, expected);
	}
	
	@Test
	public void testTwentyDays() throws NoRateException {
		BigDecimal value = new BigDecimal(1000);
		BigDecimal days = new BigDecimal(20);
		BigDecimal expected = new BigDecimal(80);
		BigDecimal result = rate.calculate(value, days);
		Assertions.assertEquals(result, expected);
	}
	
	@Test
	public void testTwentyOneDays() throws NoRateException {
		BigDecimal value = new BigDecimal(50);
		BigDecimal days = new BigDecimal(21);
		BigDecimal expected = new BigDecimal(3);
		BigDecimal result = rate.calculate(value, days);
		Assertions.assertEquals(result, expected);
	}
	
	@Test
	public void testThirtyDays() throws NoRateException {
		BigDecimal value = new BigDecimal(500);
		BigDecimal days = new BigDecimal(30);
		BigDecimal expected = new BigDecimal(30);
		BigDecimal result = rate.calculate(value, days);
		Assertions.assertEquals(result, expected);
	}
	
	@Test
	public void testThirtyTwoDays() throws NoRateException {
		BigDecimal value = new BigDecimal(100000);
		BigDecimal days = new BigDecimal(32);
		BigDecimal expected = new BigDecimal(4000);
		BigDecimal result = rate.calculate(value, days);
		Assertions.assertEquals(result, expected);
	}
	
	@Test
	public void testFortyDays() throws NoRateException {
		BigDecimal value = new BigDecimal(50000);
		BigDecimal days = new BigDecimal(40);
		BigDecimal expected = new BigDecimal(2000);
		BigDecimal result = rate.calculate(value, days);
		Assertions.assertEquals(result, expected);
	}
	
	@Test
	public void testFortyOneDays() throws NoRateException {
		BigDecimal value = new BigDecimal(1000000);
		BigDecimal days = new BigDecimal(41);
		BigDecimal expected = new BigDecimal(20000);
		BigDecimal result = rate.calculate(value, days);
		Assertions.assertEquals(result, expected);
	}
	
	@Test
	public void testFortyOneDaysAndValueLessThanOneHundred() {
		BigDecimal value = new BigDecimal(50000);
		BigDecimal days = new BigDecimal(41);
		Assertions.assertThrows(NoRateException.class, () -> rate.calculate(value, days));
	}

}
