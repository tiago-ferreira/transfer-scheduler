package com.transfer.scheduler.model.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.transfer.scheduler.model.Account;

public class AccountTest {
	

	@Test
	public void testConstructorNoArgs() {
		Account account = new Account();
		Assertions.assertNotNull(account);
		Assertions.assertNull(account.number());
	}
	
	@Test
	public void testConstructorWithArgs() {
		Account account = new Account("012345");
		Assertions.assertNotNull(account);
		Assertions.assertNotNull(account.number());
		Assertions.assertEquals(account.number(), "012345");
	}
	
	
	@Test
	public void testChangeNumber() {
		Account account = new Account("012345");
		account.number("543210");
		Assertions.assertEquals(account.number(), "543210");
	}

}
