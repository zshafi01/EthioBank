package com.simplilearn.controller;

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

import com.simplilearn.domain.Transfer;
import com.simplilearn.service.TransferService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class TransferController {
	
	@Autowired
	private TransferService transferService;
	@RequestMapping(path = "/addtransfer", method = RequestMethod.POST)
	public List<Transfer> save(@RequestBody Transfer transfer){
		
		return transferService.save(transfer);
		
	}
	@RequestMapping(path = "/transfer/{id}",method = RequestMethod.DELETE)
	public void deleteTransfer(@PathVariable("id") long id)   
	{  
		transferService.deleteTransfer(id);  
	}  
	@RequestMapping(path = "/updatetransfer",method = RequestMethod.PUT)

	public Transfer update(@RequestBody Transfer transfer, long id)   
	{  
		transferService.updateTransfer(transfer, id); 
	return transfer;  
	} 
	@GetMapping("/transfer/{id}")  
	public Optional<Transfer> getTransferById(@PathVariable("id") long id)   
	{  
	return transferService.getById(id);  
	}  
	@GetMapping("/transfers")  
	public List<Transfer> getAllTransfer(@PathVariable("id") long id)   
	{  
	return transferService.findAll();  
	}  

}

