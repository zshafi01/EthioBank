package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//	
	
	@Query(value = "select *from transaction where customer_id = ?1",nativeQuery = true)
	List<Transaction> getTransactionByCustomerId(long userid);
}
