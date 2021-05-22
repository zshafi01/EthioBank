package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.Customer;
import com.simplilearn.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public List<Customer> save(Customer customer) {
		customerRepository.save(customer);
		return findAll();
	}

	@Override
	public void updatecustomer(Customer customer, long id) {
		customerRepository.save(customer);
	}

	@Override
	public void deletecustomer(long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Optional<Customer> getById(long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
	}

}
