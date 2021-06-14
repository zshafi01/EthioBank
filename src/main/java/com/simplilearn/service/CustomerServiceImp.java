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
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer, String userId) {

		Customer customerExisting = getCustomerByUserId(userId + "");

		if (customerExisting != null) {
			return null;
		}

		Optional<User> userOptional = userService.getById(Long.parseLong(userId));
		if (userOptional.isPresent()) {
			User savedUser = userOptional.get();
			if (savedUser != null) {
				customer.setUser(savedUser);
				Customer savedCustomer = customerRepository.save(customer);
				return savedCustomer;
			}

		}
		return null;

	}

	@Override
	public Customer updatecustomer(Customer customer, long id) {
		Customer customerByUserId = this.getCustomerByUserId(id + "");
		if (customerByUserId != null) {
			customerByUserId.setAddress(customer.getAddress());
			customerByUserId.setEmail(customer.getEmail());
			customerByUserId.setFirstName(customer.getFirstName());
			customerByUserId.setLastName(customer.getLastName());
			customerByUserId.setPhone(customer.getPhone());
			customerByUserId.setSsn(customer.getSsn());
			return customerRepository.save(customerByUserId);
		}
		return null;

	}

	@Override
	public void deletecustomer(long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Optional<Customer> getById(long id) {

		return customerRepository.findById(id);
	}

	@Override
	public Customer getCustomerByUserId(String userId) {
		List<Customer> customers = customerRepository.findByUserId(userId);
		if (customers != null && !customers.isEmpty()) {
			return customers.get(0);
		}
		return null;
	}

}
