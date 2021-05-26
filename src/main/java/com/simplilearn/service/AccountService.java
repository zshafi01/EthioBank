package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.domain.Account;

public interface AccountService {
	List<Account> findAll();
	Account save(Account account, String userId);
	void updateAccount(Account account, long id);
	void deleteAccount(long id);
	public Optional<Account> getById(long id);
}
