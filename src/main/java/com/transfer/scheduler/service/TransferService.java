package com.transfer.scheduler.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.transfer.scheduler.dao.TransferDAO;
import com.transfer.scheduler.model.Transfer;

@Service
public class TransferService {

	public Transfer save(Transfer transfer) {
		transfer.rate(new BigDecimal("10"));
		transfer.schedulerDate(LocalDate.now());
		TransferDAO.save(transfer);
		return transfer;
	}
	
	public List<Transfer> getList() {
		return TransferDAO.getList();
	}
}
