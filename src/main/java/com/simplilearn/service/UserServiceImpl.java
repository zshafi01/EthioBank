package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.User;
import com.simplilearn.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public List<User> findAll() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public List<User> save(User user) {
		userRepository.save(user);
		return findAll();
	}

	@Override
	public void updateUser(User user, long id) {
		userRepository.save(user);	
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);		
	}

	@Override
	public Optional<User> getById(long id) {
		return userRepository.findById(id);
	}

}
