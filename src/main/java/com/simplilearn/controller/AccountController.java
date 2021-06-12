package com.simplilearn.controller;

import java.util.List;
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
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class AccountController {
	@Autowired
	private AccountService accountService;


	@RequestMapping(path = "/addaccount/{userId}", method = RequestMethod.POST)
	public Account save(@PathVariable("userId") String userId,  @RequestBody Account account){		
		return accountService.save(account, userId);
		
	}
	
	@GetMapping("/accountsByUserId/{id}") 
	public List<Account> getAccountByUserId(@PathVariable("id") long id){
		return accountService.getAccountByUserId(id);
	}
	
	@GetMapping("/deposit/{accountId}/{amount}")
	public void deposit(@PathVariable("accountId") String accountId, @PathVariable("amount") String amount) {
		
		accountService.deposit(Long.parseLong(accountId), Double.parseDouble(amount));
	}
	@GetMapping("/withdrawl/{accountId}/{amount}")
	public void withdrawl(@PathVariable("accountId") String accountId, @PathVariable("amount") String amount) throws Exception {
		
		accountService.withdrawl(Long.parseLong(accountId), Double.parseDouble(amount));
	}
	
	@GetMapping("/listofaccounts")  
	public List<Account> listofaccounts(){  
	return accountService.findAll(); 
	} 
	
	
	//not used
	
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
	 
 
 
	
	


}

