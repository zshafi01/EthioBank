package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.domain.Recipents;

public interface RecipentsService {
	List<Recipents> findAll();
	String save(Recipents recipents, long userId);
	void updateRecipents(Recipents recipents, long id);
	void deleteRecipents(long id);
	public Optional<Recipents> getById(long id);
	List<Recipents> getByUserId(long id);

}
