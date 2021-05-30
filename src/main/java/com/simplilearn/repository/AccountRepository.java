package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;import org.springframework.stereotype.Repository;

import com.simplilearn.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query(value = "select * from Account where customer_id=?1", nativeQuery = true)
	List<Account> findAcctByCustId(String custId);
	
	

//	@Query(value = "update Account set balance= balance + ?2 where account_number=?1", nativeQuery = true)
//	void deposit(String accountId,double amount);
//	
//	@Query(value = "update Account set balance= balance - ?2 where account_number=?1", nativeQuery = true)
//	void withdrwal(String accountId, double amount);
}
