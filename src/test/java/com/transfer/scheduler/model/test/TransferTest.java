package com.transfer.scheduler.model.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.transfer.scheduler.model.Account;
import com.transfer.scheduler.model.Transfer;

class TransferTest {
	
	
	Account origin;
	Account destiny;
	LocalDate today;
	LocalDate tomorrow;
	BigDecimal transferValue;
	BigDecimal rate;
	
	@Before
	void init() {
		origin = new Account("012345");
		destiny = new Account("543210");
		today = LocalDate.now();
		tomorrow = today.plusDays(1);
		transferValue = new BigDecimal("10");
		rate = new BigDecimal("3");
	}
	
	@Test
	void testConstructorNoArgs() {
		Transfer transfer = new Transfer();
		Assert.assertNotNull(transfer);
		Assert.assertNull(transfer.origin());
		Assert.assertNull(transfer.destiny());
		Assert.assertNull(transfer.transferValue());
		Assert.assertNull(transfer.rate());
		Assert.assertNull(transfer.transferDate());
		Assert.assertNull(transfer.schedulerDate());

	}
	
	@Test
	void testConstructorWithArgs() {
		Transfer transfer = new Transfer(origin, destiny, transferValue, rate , today, today);
		Assert.assertNotNull(transfer);
		Assert.assertNull(transfer.origin());
		Assert.assertNull(transfer.destiny());
		Assert.assertNull(transfer.transferValue());
		Assert.assertNull(transfer.rate());
		Assert.assertNull(transfer.transferDate());
		Assert.assertNull(transfer.schedulerDate());
		Assert.assertEquals(transfer.origin(), origin);
		Assert.assertEquals(transfer.destiny(), destiny);
		Assert.assertEquals(transfer.transferValue(), transferValue);
		Assert.assertEquals(transfer.rate(), rate);
		Assert.assertEquals(transfer.transferDate(), today);
		Assert.assertEquals(transfer.schedulerDate(), today);

	}
	
	
	@Test
	void testChangeOrigin() {
		Transfer transfer = new Transfer();
		transfer.origin(destiny);
		Assert.assertEquals(transfer.origin(), destiny);
	}
	
	@Test
	void testChangeDestiny() {
		Transfer transfer = new Transfer();
		transfer.destiny(origin);
		Assert.assertEquals(transfer.destiny(), origin);
	}
	
	@Test
	void testChangeTransferValue() {
		Transfer transfer = new Transfer();
		transfer.transferValue(rate);
		Assert.assertEquals(transfer.transferValue(), rate);
	}
	
	@Test
	void testChangeRate() {
		Transfer transfer = new Transfer();
		transfer.rate(transferValue);
		Assert.assertEquals(transfer.rate(), transferValue);
	}
	
	@Test
	void testChangeTransferDate() {
		Transfer transfer = new Transfer();
		transfer.transferDate(tomorrow);
		Assert.assertEquals(transfer.transferDate(), tomorrow);
	}
	
	@Test
	void testChangeSchedulerDate() {
		Transfer transfer = new Transfer();
		transfer.schedulerDate(tomorrow);
		Assert.assertEquals(transfer.schedulerDate(), tomorrow);
	}

}
