package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.Customer;
import com.simplilearn.domain.Recipents;
import com.simplilearn.repository.AccountRepository;
import com.simplilearn.repository.CustomerRepository;
import com.simplilearn.repository.RecipentsRepository;

@Service
public class RecipentsServiceImpl implements RecipentsService {

	@Autowired
	private RecipentsRepository recipentsRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public String save(Recipents recipents, long userId) {

		Customer customer = customerRepository.findByPhone(recipents.getPhone());
		if (customer != null) {
			if (customer.getAccounts() != null && !customer.getAccounts().isEmpty()) {
				recipents.setUserId(userId);
				recipents.setAccountId(customer.getAccounts().get(0).getId());
				Recipents savedRecipent = recipentsRepository.save(recipents);
				if (savedRecipent != null) {
					return "success";
				} else {
					return "not able to save";
				}
			} else {
				return "No account with this phone.";
			}
		}

		return "No customer with this phone.";

	}

	@Override
	public List<Recipents> getByUserId(long id) {

		return recipentsRepository.findAllByUserId(id);
	}

	@Override
	public List<Recipents> findAll() {
		return (List<Recipents>) recipentsRepository.findAll();
	}

	@Override
	public void updateRecipents(Recipents recipents, long id) {
		recipentsRepository.save(recipents);
	}

	@Override
	public void deleteRecipents(long id) {
		recipentsRepository.deleteById(id);
	}

	@Override
	public Optional<Recipents> getById(long id) {
		return recipentsRepository.findById(id);
	}

}
