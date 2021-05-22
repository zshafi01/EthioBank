package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.domain.ChequeBookRequest;

public interface ChequeBookRequestSevice {

	List<ChequeBookRequest> findAll();
	List<ChequeBookRequest> save(ChequeBookRequest chequeBookRequest);
	void updateChequeBookRequest(ChequeBookRequest chequeBookRequest, long id);
	void deleteChequeBookRequest(long id);
	public Optional<ChequeBookRequest> getById(long id);
}
