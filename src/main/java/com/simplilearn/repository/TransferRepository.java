package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.domain.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
