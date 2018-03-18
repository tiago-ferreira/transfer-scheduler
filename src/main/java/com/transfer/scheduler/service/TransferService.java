package com.transfer.scheduler.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transfer.scheduler.business.CalculateRate;
import com.transfer.scheduler.dao.TransferDAO;
import com.transfer.scheduler.model.Transfer;

@Service
public class TransferService {
	
	@Autowired
	private CalculateRate calculateRate;

	public Transfer save(Transfer transfer) throws Exception {
		validOldDate(transfer);
		validSameAccountOriginAndDestiny(transfer);
		transfer.schedulerDate(LocalDate.now());
		BigDecimal rate = calculateRate.applyRate(transfer.transferValue(), transfer.schedulerDate(), transfer.transferDate());
		transfer.rate(rate);
		TransferDAO.save(transfer);
		return transfer;
	}
	
	private void validSameAccountOriginAndDestiny(Transfer transfer) throws Exception {
		if(transfer.origin().equals(transfer.destiny())) {
			throw new Exception("The destiny account cannot be equals the origin account.");
		}
	}

	private void validOldDate(Transfer transfer) throws Exception {
		if(transfer.transferDate().isBefore(LocalDate.now())) {
			throw new Exception("The transferDate cannot less than today.");
		}
	}

	public List<Transfer> getList() {
		return TransferDAO.getList();
	}
}
