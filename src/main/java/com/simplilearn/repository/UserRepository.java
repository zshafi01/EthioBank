package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> getByemail(String email);

}
