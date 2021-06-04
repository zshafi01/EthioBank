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
	public User save(User user) {
		User saveduser= userRepository.save(user);
		return saveduser;
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
	public List<User> getByEmail(String email){
		
		return  userRepository.getByemail(email);
	}

	@Override
	public User verifyUser(User user) {
		List<User> users = getByEmail(user.getEmail());
		if(users==null||users.isEmpty()) {
			return null;
		}
		User userfound = users.get(0);
		if (userfound!=null && userfound.getPassword().equals(user.getPassword())) {
			return userfound;
		}else {
			return null;
		}
		
	}
	
	

		
	

	
	}
