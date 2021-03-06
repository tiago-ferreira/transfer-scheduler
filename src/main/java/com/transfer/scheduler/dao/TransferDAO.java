package com.transfer.scheduler.dao;

import java.util.LinkedList;
import java.util.List;

import com.transfer.scheduler.model.Transfer;

public class TransferDAO {

	private static List<Transfer> transfers = new LinkedList<>();
	
	private TransferDAO() {
	}
	
	public static void save(Transfer transfer) {
		transfers.add(transfer);
	}
	
	public static List<Transfer> getList(){
		return transfers;
	}
	
	public static int size() {
		return transfers.size();
	}
	
	public static void clear() {
		transfers.clear();
	}
	
	public static void remove(Transfer transfer) {
		transfers.remove(transfer);
	}
	
	public static void removeAll(List<Transfer> transfersToRemove) {
		transfers.removeAll(transfersToRemove);
	}
}
