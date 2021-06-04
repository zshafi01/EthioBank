package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.domain.Customer;
import java.util.*;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "SELECT * FROM ethiobankdb.customer where user_id=:userId",nativeQuery = true)
	List<Customer> findByUserId(@Param("userId") String userId);

	Customer findByPhone(String phone);

}
