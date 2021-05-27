package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.Customer;
import com.simplilearn.domain.User;
import com.simplilearn.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer, String userId) {
		
		Optional<User> userOptional = userService.getById(Long.parseLong(userId));
		if(userOptional.isPresent()) {
			User savedUser = userOptional.get();
			if(savedUser!=null) {
				customer.setUser(savedUser);
				Customer savedCustomer = customerRepository.save(customer);
				return savedCustomer;
			}
			
		}
		return null;
		
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
