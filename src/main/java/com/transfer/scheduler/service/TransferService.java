package com.transfer.scheduler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.transfer.scheduler.dao.TransferDAO;
import com.transfer.scheduler.model.Transfer;

@Service
public class TransferService {

	public void save(Transfer transfer) {
		TransferDAO.save(transfer);
	}
	
	public List<Transfer> getList() {
		return TransferDAO.getList();
	}
}
