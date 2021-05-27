package com.simplilearn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.domain.User;
import com.simplilearn.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class userController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/adduser", method = RequestMethod.POST)
	public User save(@RequestBody User user){
		
		return userService.save(user);
		
	}
//	@RequestMapping(path = "/login", method = RequestMethod.POST,produces = { "application/json" })
//	public User login(@RequestBody User user){
//		
//		 User verifyUser = userService.verifyUser(user);
//		 return verifyUser;
//		
//	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User user){
		 return userService.verifyUser(user);
		
	}
	
	
	
	@RequestMapping(path = "/user/{id}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") long id)   
	{  
		userService.deleteUser(id);  
	}  
	
	@RequestMapping(path = "/updateuser",method = RequestMethod.PUT)

	public User update(@RequestBody User user, long id)   
	{  
		userService.updateUser(user, id); 
	return user;  
	} 
	@GetMapping("/user/{id}")  
	public Optional<User> getUserById(@PathVariable("id") long id)   
	{  
	return userService.getById(id);  
	}  
	@GetMapping("/users")  
	public List<User> getAllUsers()   
	{  
	return userService.findAll();  
	}  

}
