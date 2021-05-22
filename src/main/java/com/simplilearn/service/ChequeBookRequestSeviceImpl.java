package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.ChequeBookRequest;
import com.simplilearn.repository.ChequeBookRequestRepository;

@Service
public class ChequeBookRequestSeviceImpl implements ChequeBookRequestSevice {

	@Autowired
	private ChequeBookRequestRepository chequeBookRequestRepository;
	@Override
	public List<ChequeBookRequest> findAll() {
		return  (List<ChequeBookRequest>) chequeBookRequestRepository.findAll();
	}

	@Override
	public List<ChequeBookRequest> save(ChequeBookRequest chequeBookRequest) {
		chequeBookRequestRepository.save(chequeBookRequest);
		
		return findAll();
	}

	@Override
	public void updateChequeBookRequest(ChequeBookRequest chequeBookRequest, long id) {
		chequeBookRequestRepository.save(chequeBookRequest);		
	}

	@Override
	public void deleteChequeBookRequest(long id) {
		chequeBookRequestRepository.deleteById(id);		
	}

	@Override
	public Optional<ChequeBookRequest> getById(long id) {
		return chequeBookRequestRepository.findById(id);
	}

}
