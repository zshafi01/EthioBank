package com.simplilearn.repository;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.domain.Recipents;

public interface RecipentsRepository extends CrudRepository<Recipents, Long> {

}
