package com.simplilearn.repository;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.domain.Transfer;

public interface TransferRepository extends CrudRepository<Transfer, Long> {

}
