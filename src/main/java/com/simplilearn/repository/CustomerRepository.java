package com.simplilearn.repository;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
