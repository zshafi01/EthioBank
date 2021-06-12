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

import com.simplilearn.domain.ChequeBookRequest;
import com.simplilearn.service.ChequeBookRequestSevice;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class CheckRequestController {
	@Autowired
	private ChequeBookRequestSevice chequeBookRequestSevice;

	@RequestMapping(path = "/addcheckreq", method = RequestMethod.POST)
	public ChequeBookRequest save(@RequestBody ChequeBookRequest chequeBookRequest){
		
		 return chequeBookRequestSevice.save(chequeBookRequest);
		
	}
	@RequestMapping(path = "/chequeBookRequest/{id}",method = RequestMethod.DELETE)
	public void deleteChequeBookRequest(@PathVariable("id") long id)   
	{  
		chequeBookRequestSevice.deleteChequeBookRequest(id);  
	}  
	@RequestMapping(path = "/updateChequeBookRequest",method = RequestMethod.PUT)

	public ChequeBookRequest update(@RequestBody ChequeBookRequest chequeBookRequest, long id)   
	{  
		chequeBookRequestSevice.updateChequeBookRequest(chequeBookRequest, id); 
	return chequeBookRequest;  
	} 
	@GetMapping("/chequeBookRequest/{id}")  
	public Optional<ChequeBookRequest> getCustomerById(@PathVariable("id") long id)   
	{  
	return chequeBookRequestSevice.getById(id);  
	}  
	
	@GetMapping("/chequeBookRequests")  
	public List<ChequeBookRequest> getAllCustomer(@PathVariable("id") long id)   
	{  
	return chequeBookRequestSevice.findAll();  
	}  

}
