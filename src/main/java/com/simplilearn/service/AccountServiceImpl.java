package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.Account;
import com.simplilearn.domain.Customer;
import com.simplilearn.domain.User;
import com.simplilearn.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerService customerService;

	@Override
	public List<Account> findAll() {
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public Account save(Account account, String userId) {
		Optional<Customer> customerOptional = customerService.getById(Long.parseLong(userId));
		if(customerOptional.isPresent()) {
			Customer savedCustomer = customerOptional.get();
			if(savedCustomer!=null) {
				account.setCustomer(savedCustomer);
				Account savedaccount = accountRepository.save(account);
				return savedaccount;
			}
			
		}
		return null;
		
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
