package com.simplilearn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.domain.Customer;
import com.simplilearn.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/addcustomer", method = RequestMethod.POST)
	public List<Customer> save(@RequestBody Customer customer){
		
		return customerService.save(customer);
		
	}
	@RequestMapping(path = "/customer/{id}",method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("id") long id)   
	{  
	customerService.deletecustomer(id);  
	}  
	@RequestMapping(path = "/updatecustomers",method = RequestMethod.PUT)

	public Customer update(@RequestBody Customer customer, long id)   
	{  
		customerService.updatecustomer(customer, id); 
	return customer;  
	} 
	@GetMapping("/customer/{id}")  
	public Optional<Customer> getCustomerById(@PathVariable("id") long id)   
	{  
	return customerService.getById(id);  
	}  
	@GetMapping("/customers")  
	public List<Customer> getAllCustomer(@PathVariable("id") long id)   
	{  
	return customerService.findAll();  
	}  

}
