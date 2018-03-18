package com.transfer.scheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.transfer.scheduler.model.Transfer;
import com.transfer.scheduler.service.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	
	@Autowired
	private TransferService transferService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Transfer save(@RequestBody Transfer transfer) throws Exception {
		return transferService.save(transfer);
	}
	
	@GetMapping
	public List<Transfer> getList() {
		return transferService.getList();
	}
}
