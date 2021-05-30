package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.domain.ChequeBookRequest;

@Repository
public interface ChequeBookRequestRepository extends JpaRepository<ChequeBookRequest, Long>{

}
