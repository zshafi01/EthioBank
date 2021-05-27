package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.domain.Transfer;

public interface TransferService {
	List<Transfer> findAll();
	Transfer save(Transfer transfer, String userId);
	void updateTransfer(Transfer transfer, long id);
	void deleteTransfer(long id);
	public Optional<Transfer> getById(long id);


}
