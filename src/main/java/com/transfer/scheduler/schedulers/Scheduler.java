package com.transfer.scheduler.schedulers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.transfer.scheduler.dao.TransferDAO;
import com.transfer.scheduler.model.Transfer;

@Component
public class Scheduler {

	@Scheduled(fixedDelay = 150000)
	public void scheduler() {
		List<Transfer> transfers = filterTransfersToSchedulerToday();
		transfers.forEach(System.out::println);
		TransferDAO.removeAll(transfers);
	}

	private List<Transfer> filterTransfersToSchedulerToday() {
		List<Transfer> toReturn = TransferDAO.getList()
				.stream()
				.filter((a) -> a.transferDate().equals(LocalDate.now()))
				.collect(Collectors.toList());
		return toReturn;
	}
}
