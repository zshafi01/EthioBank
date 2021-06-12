package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.simplilearn.domain.Transaction;
import com.simplilearn.service.TransactionService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin

public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping(path = "/listoftransaction/{userId}")
	public List<Transaction> getTransactionByCustomerId(@PathVariable("userId") long userId){
		return transactionService.gettransactionbyuserid(userId);
	}
}

