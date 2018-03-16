package com.transfer.scheduler.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transfer.scheduler.business.CalculateRate;
import com.transfer.scheduler.dao.TransferDAO;
import com.transfer.scheduler.exceptions.NoRateException;
import com.transfer.scheduler.model.Transfer;

@Service
public class TransferService {
	
	@Autowired
	private CalculateRate calculateRate;

	public Transfer save(Transfer transfer) throws NoRateException {
		transfer.schedulerDate(LocalDate.now());
		BigDecimal rate = calculateRate.applyRate(transfer.transferValue(), transfer.schedulerDate(), transfer.transferDate());
		transfer.rate(rate);
		TransferDAO.save(transfer);
		return transfer;
	}
	
	public List<Transfer> getList() {
		return TransferDAO.getList();
	}
}
