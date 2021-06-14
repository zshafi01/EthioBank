package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.Customer;
import com.simplilearn.domain.Transaction;
import com.simplilearn.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private CustomerService customerService;

	@Override
	public List<Transaction> findAlltransactiton() {
		return null;
	}

	@Override
	public List<Transaction> gettransactionbyuserid(long userid) {

		Customer customer = customerService.getCustomerByUserId(userid + "");
		List<Transaction> listoftransactions = transactionRepository.getTransactionByCustomerId(customer.getId());
		return listoftransactions;
	}

}