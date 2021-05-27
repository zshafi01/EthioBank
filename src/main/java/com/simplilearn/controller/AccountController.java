package com.simplilearn.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.domain.Account;
import com.simplilearn.service.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	@Autowired
	private AccountService accountService;


	@RequestMapping(path = "/addaccount/{userId}", method = RequestMethod.POST)
	public Account save(@PathVariable("userId") String userId,  @RequestBody Account account){

//		account.setCustomer(null);
		
		return accountService.save(account, userId);
		
	}
	@RequestMapping(path = "/account/{id}",method = RequestMethod.DELETE)
	public void deleteAccount(@PathVariable("id") long id)   
	{  
		accountService.deleteAccount(id);  
	}  
	@RequestMapping(path = "/updateaccount",method = RequestMethod.PUT)

	public Account update(@RequestBody Account account, long id)   
	{  
		accountService.updateAccount(account, id); 
	return account;  
	} 
	@GetMapping("/account/{id}")  
	public Optional<Account> getAccountById(@PathVariable("id") long id)   
	{  
	return accountService.getById(id);  
	}  
	@GetMapping("/accounts")  
	public List<Account> getAllAccount(@PathVariable("id") long id)   
	{  
	return accountService.findAll(); 
	}  


}

