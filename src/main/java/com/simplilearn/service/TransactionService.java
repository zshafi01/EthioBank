package com.simplilearn.service;

import java.util.List;

import com.simplilearn.domain.Transaction;

public interface TransactionService {
	List<Transaction> findAlltransactiton();

	List<Transaction> gettransactionbyuserid(long userid);

}
