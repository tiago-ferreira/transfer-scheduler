package com.transfer.scheduler.dao.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	List<Transfer> transfers;
	List<Transfer> transfersToRemove;

	@BeforeEach
	public void init() {
		transfers = new ArrayList<>();
		today = LocalDate.now();
		for (int i = 0; i < 10; i++) {
			origin = new Account(String.valueOf("00000" + i));
			destiny = new Account(String.valueOf("00000" + i));
			transferValue = new BigDecimal("10" + i);
			rate = new BigDecimal("1" + i);
			transfers.add(new Transfer(origin, destiny, transferValue, rate, today, today));
		}
		transfersToRemove = transfers.subList(0, 2);
	}

	@Test
	public void testAdd() {
		saveTen();
		Assertions.assertTrue(TransferDAO.size() == 10);
	}

	@Test
	public void testGEtList() {
		Assertions.assertNotNull(TransferDAO.getList());
		Assertions.assertTrue(TransferDAO.size() == 10);
	}

	@Test
	public void testClear() {
		TransferDAO.clear();
		Assertions.assertNotNull(TransferDAO.getList());
		Assertions.assertTrue(TransferDAO.size() == 0);
	}
	
	@Test
	public void testRemove() {
		TransferDAO.save(new Transfer());
		Assertions.assertTrue(TransferDAO.size() == 1);
		TransferDAO.remove(new Transfer());
		Assertions.assertTrue(TransferDAO.size() == 0);
	}
	
	
	@Test
	public void testRemoveAll() {
		saveTen();
		Assertions.assertTrue(TransferDAO.size() == 10);
		TransferDAO.removeAll(transfersToRemove);
		Assertions.assertTrue(TransferDAO.size() == 8);
	}

	
	private void saveTen() {
		TransferDAO.clear();
		for(Transfer transfer : transfers) {
			TransferDAO.save(transfer);			
		}
	}
}
