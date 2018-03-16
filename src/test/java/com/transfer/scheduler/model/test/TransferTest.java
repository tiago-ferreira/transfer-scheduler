package com.transfer.scheduler.model.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.transfer.scheduler.model.Account;
import com.transfer.scheduler.model.Transfer;

public class TransferTest {
	
	
	Account origin;
	Account destiny;
	LocalDate today;
	LocalDate tomorrow;
	BigDecimal transferValue;
	BigDecimal rate;
	
	@BeforeEach
	public void init() {
		origin = new Account("012345");
		destiny = new Account("543210");
		today = LocalDate.now();
		tomorrow = today.plusDays(1);
		transferValue = new BigDecimal("10");
		rate = new BigDecimal("3");
	}
	
	@Test
	public void testConstructorNoArgs() {
		Transfer transfer = new Transfer();
		Assertions.assertNotNull(transfer);
		Assertions.assertNull(transfer.origin());
		Assertions.assertNull(transfer.destiny());
		Assertions.assertNull(transfer.transferValue());
		Assertions.assertNull(transfer.rate());
		Assertions.assertNull(transfer.transferDate());
		Assertions.assertNull(transfer.schedulerDate());

	}
	
	@Test
	public void testConstructorWithArgs() {
		Transfer transfer = new Transfer(origin, destiny, transferValue, rate , today, today);
		Assertions.assertNotNull(transfer);
		Assertions.assertNotNull(transfer.origin());
		Assertions.assertNotNull(transfer.destiny());
		Assertions.assertNotNull(transfer.transferValue());
		Assertions.assertNotNull(transfer.rate());
		Assertions.assertNotNull(transfer.transferDate());
		Assertions.assertNotNull(transfer.schedulerDate());
		Assertions.assertEquals(transfer.origin(), origin);
		Assertions.assertEquals(transfer.destiny(), destiny);
		Assertions.assertEquals(transfer.transferValue(), transferValue);
		Assertions.assertEquals(transfer.rate(), rate);
		Assertions.assertEquals(transfer.transferDate(), today);
		Assertions.assertEquals(transfer.schedulerDate(), today);

	}
	
	
	@Test
	public void testChangeOrigin() {
		Transfer transfer = new Transfer();
		transfer.origin(destiny);
		Assertions.assertEquals(transfer.origin(), destiny);
	}
	
	@Test
	public void testChangeDestiny() {
		Transfer transfer = new Transfer();
		transfer.destiny(origin);
		Assertions.assertEquals(transfer.destiny(), origin);
	}
	
	@Test
	public void testChangeTransferValue() {
		Transfer transfer = new Transfer();
		transfer.transferValue(rate);
		Assertions.assertEquals(transfer.transferValue(), rate);
	}
	
	@Test
	public void testChangeRate() {
		Transfer transfer = new Transfer();
		transfer.rate(transferValue);
		Assertions.assertEquals(transfer.rate(), transferValue);
	}
	
	@Test
	public void testChangeTransferDate() {
		Transfer transfer = new Transfer();
		transfer.transferDate(tomorrow);
		Assertions.assertEquals(transfer.transferDate(), tomorrow);
	}
	
	@Test
	public void testChangeSchedulerDate() {
		Transfer transfer = new Transfer();
		transfer.schedulerDate(tomorrow);
		Assertions.assertEquals(transfer.schedulerDate(), tomorrow);
	}

}
