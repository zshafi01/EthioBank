package com.simplilearn.repository;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
