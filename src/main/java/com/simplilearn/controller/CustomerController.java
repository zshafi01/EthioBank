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

import com.simplilearn.domain.Customer;
import com.simplilearn.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/addcustomer/{userId}", method = RequestMethod.POST)
	public Customer save(@PathVariable("userId") String userId,  @RequestBody Customer customer){
				return customerService.save(customer,userId);
			}
	
	@GetMapping("/customerUserId/{userId}")  
	public Customer getCustomerByUserId(@PathVariable("userId") long userId)   
	{  
	return customerService.getCustomerByUserId(userId+"");  
	}
	
	@GetMapping("/listofcustomers")  
	public List<Customer> listofcustomers(){
		return customerService.findAll();
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
	@RequestMapping(path = "/customer/{id}",method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("id") long id)   
	{  
	customerService.deletecustomer(id);  
	}  
	
	@RequestMapping(path = "/updatecustomers/{id}",method = RequestMethod.PUT)
	public Customer update(@PathVariable("id") long id, @RequestBody Customer customer)   
	{  
		return customerService.updatecustomer(customer, id); 
	} 
	

}
