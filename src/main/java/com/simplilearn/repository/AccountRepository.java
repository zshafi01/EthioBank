package com.simplilearn.repository;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
