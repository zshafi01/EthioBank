package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.Transfer;
import com.simplilearn.repository.TransferRepository;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private TransferRepository transferRepository;
	@Override
	public List<Transfer> findAll() {
		return (List<Transfer>) transferRepository.findAll();
	}

	@Override
	public List<Transfer> save(Transfer transfer) {
		transferRepository.save(transfer);
		return findAll();
	}

	@Override
	public void updateTransfer(Transfer transfer, long id) {
		transferRepository.save(transfer);		
	}

	@Override
	public void deleteTransfer(long id) {
		transferRepository.deleteById(id);		
	}

	@Override
	public Optional<Transfer> getById(long id) {
		return transferRepository.findById(id);
	}

}
