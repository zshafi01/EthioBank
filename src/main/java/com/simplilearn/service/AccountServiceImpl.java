package com.simplilearn.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.Account;
import com.simplilearn.domain.Customer;
import com.simplilearn.domain.Transaction;
import com.simplilearn.repository.AccountRepository;
import com.simplilearn.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private TransactionRepository transactionRepository;
	
	Transaction  transaction = new Transaction();

	@Override
	public List<Account> findAll() {
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public Account save(Account account, String userId) {
		account.setChequeBookRequest(null);
		account.setDate(new Date());
		
		Customer customer = customerService.getCustomerByUserId(userId);

		if(customer!=null) {
			account.setCustomer(customer);
			Account savedaccount = accountRepository.save(account);
			return savedaccount;
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
	public List<Account> getAccountByUserId(long id) {

	Customer customer = customerService.getCustomerByUserId(id+"");
	if(customer!=null) {
		return accountRepository.findAcctByCustId(customer.getId()+"");
	}

	return null;
		
	}

	@Override
	public void deposit(long accountId, double amount) {
		Optional<Account> findById = accountRepository.findById(accountId);
		if(findById.isPresent()) {
			Account account = findById.get();
			account.setBalance(account.getBalance()+amount);
			accountRepository.save(account);
			transaction.setDate(new Date());
//			transaction.setDescription(account.g);
			transaction.setCustomerId(account.getCustomer().getId()+"");
			transaction.setAccountId(account.getId());
			transaction.setType(account.getTypes());
			transaction.setAmount("+"+Double.toString (amount));
			transaction.setBalance(Double.toString (account.getBalance()));
			transactionRepository.save(transaction);
		}
	}

	@Override
	public void withdrawl(long accountId, double amount) {
		Optional<Account> findById = accountRepository.findById(accountId);
		if(findById.isPresent()) {
			Account account = findById.get();
			account.setBalance(account.getBalance() -amount);
			accountRepository.save(account);
			transaction.setDate(new Date());
//			transaction.setDescription(account.g);
			transaction.setCustomerId(account.getCustomer().getId()+"");
			transaction.setAccountId(account.getId());
			transaction.setType(account.getTypes());
			transaction.setAmount("-"+Double.toString (amount));
			transaction.setBalance(Double.toString (account.getBalance()));
			transactionRepository.save(transaction);
		}
		
	}

}
