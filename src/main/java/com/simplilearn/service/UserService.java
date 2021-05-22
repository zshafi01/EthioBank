package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.domain.User;

public interface UserService {
	
	List<User> findAll();
	List<User> save(User user);
	void updateUser(User user, long id);
	void deleteUser(long id);
	public Optional<User> getById(long id);

}
