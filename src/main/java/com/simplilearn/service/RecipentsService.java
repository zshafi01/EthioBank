package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.domain.Recipents;

public interface RecipentsService {
	List<Recipents> findAll();
	List<Recipents> save(Recipents recipents);
	void updateRecipents(Recipents recipents, long id);
	void deleteRecipents(long id);
	public Optional<Recipents> getById(long id);

}
