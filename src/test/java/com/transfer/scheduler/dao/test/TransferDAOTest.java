package com.transfer.scheduler.dao.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.transfer.scheduler.dao.TransferDAO;
import com.transfer.scheduler.model.Account;
import com.transfer.scheduler.model.Transfer;

public class TransferDAOTest {
	
	Account origin;
	Account destiny;
	LocalDate today;
	BigDecimal transferValue;
	BigDecimal rate;
	
	@BeforeEach
	public void init() {
		today = LocalDate.now();
	}
	
	@Test
	public void testAdd() {
		for(int i =0; i < 10; i++) {
			origin = new Account(String.valueOf("00000"+i));
			destiny = new Account(String.valueOf("00000"+i));
			transferValue = new BigDecimal("10"+i);
			rate = new BigDecimal("1"+i);
			TransferDAO.save(new Transfer(origin, destiny, transferValue, rate , today, today));
		}
		Assertions.assertTrue(TransferDAO.size() == 10);
	}
	
	@Test
	public void testGEtList() {
		Assertions.assertNotNull(TransferDAO.getList());
		Assertions.assertTrue(TransferDAO.size() == 10);
	}

}
