package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.Account;
import com.simplilearn.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> findAll() {
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public List<Account> save(Account account) {
		accountRepository.save(account);
		
		return findAll();
	}

	@Override
	public void updateAccount(Account account, long id) {
		accountRepository.save(account);		
	}

	@Override
	public void deleteAccount(long id) {
		accountRepository.deleteById(id);		
	}

	@Override
	public Optional<Account> getById(long id) {
		return accountRepository.findById(id);
	}

}
