package com.simplilearn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> getByemail(String email);

}
