package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.domain.Customer;

public interface CustomerService {
	
	List<Customer> findAll();
	List<Customer> save(Customer customer);
	void updatecustomer(Customer customer, long id);
	void deletecustomer(long id);
	public Optional<Customer> getById(long id);
}
