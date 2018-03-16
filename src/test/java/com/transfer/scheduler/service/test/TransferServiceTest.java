package com.transfer.scheduler.service.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.transfer.scheduler.exceptions.NoRateException;
import com.transfer.scheduler.model.Account;
import com.transfer.scheduler.model.Transfer;
import com.transfer.scheduler.service.TransferService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransferServiceTest {

	Account origin;
	Account destiny;
	LocalDate today;
	BigDecimal transferValue;
	BigDecimal rate;
	
	@Autowired
	private TransferService transferService;
	
	@BeforeEach
	public void init() {
		today = LocalDate.now();
		origin = new Account(String.valueOf("000001"));
		destiny = new Account(String.valueOf("000002"));
		transferValue = new BigDecimal("10");
		rate = new BigDecimal("1");
	}
	
	@Test
	public void testSaveAndGetList() throws NoRateException {
		transferService.save(new Transfer(origin, destiny, transferValue, rate , today, today));
		Assertions.assertNotNull(transferService.getList());
	}
	

}
