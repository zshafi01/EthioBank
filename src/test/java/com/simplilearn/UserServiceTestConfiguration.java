package com.simplilearn;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.simplilearn.service.UserService;

@Profile("test")
@Configuration
public class UserServiceTestConfiguration {
	@Bean
	@Primary
	public UserService userService() {
		return Mockito.mock(UserService.class);
		
	}

}
