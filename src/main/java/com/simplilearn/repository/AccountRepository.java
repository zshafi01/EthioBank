package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query(value = "select * from account where customer_id=?1", nativeQuery = true)
	List<Account> findAcctByCustId(String custId);

	@Query(value = "SELECT * FROM account", nativeQuery = true)
	List<Account> findAllCustome();

}
