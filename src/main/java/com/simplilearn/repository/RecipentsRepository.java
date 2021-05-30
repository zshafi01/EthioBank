package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.domain.Recipents;

@Repository
public interface RecipentsRepository extends JpaRepository<Recipents, Long> {

}
