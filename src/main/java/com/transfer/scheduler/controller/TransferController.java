package com.transfer.scheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transfer.scheduler.model.Transfer;
import com.transfer.scheduler.service.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	
	@Autowired
	private TransferService transferService;

	@PostMapping
	public Transfer save(@RequestBody Transfer transfer) {
		return transferService.save(transfer);
	}
	
	@GetMapping
	public List<Transfer> getList() {
		return transferService.getList();
	}
}
