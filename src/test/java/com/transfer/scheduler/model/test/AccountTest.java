package com.transfer.scheduler.model.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.transfer.scheduler.model.Account;

class AccountTest {
	

	@Test
	void testConstructorNoArgs() {
		Account account = new Account();
		Assert.assertNotNull(account);
		Assert.assertNull(account.number());
	}
	
	@Test
	void testConstructorWithArgs() {
		Account account = new Account("012345");
		Assert.assertNotNull(account);
		Assert.assertNotNull(account.number());
		Assert.assertEquals(account.number(), "012345");
	}
	
	
	@Test
	void testChangeNumber() {
		Account account = new Account("012345");
		account.number("543210");
		Assert.assertEquals(account.number(), "543210");
	}

}
