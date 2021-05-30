package com.simplilearn.service;

import java.util.List;

import com.simplilearn.domain.Account;

public interface AccountService {
	List<Account> findAll();
	Account save(Account account, String userId);
	void updateAccount(Account account, long id);
	void deleteAccount(long id);
	public List<Account> getAccountByUserId(long id);
	void deposit(long l, double amount);
	void withdrawl(long l, double amount);
	
}
