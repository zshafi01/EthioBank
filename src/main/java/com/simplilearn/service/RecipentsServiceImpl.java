package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.Recipents;
import com.simplilearn.repository.RecipentsRepository;

@Service
public class RecipentsServiceImpl implements RecipentsService {

	@Autowired
	private RecipentsRepository recipentsRepository;
	@Override
	public List<Recipents> findAll() {
		return (List<Recipents>) recipentsRepository.findAll();
	}

	@Override
	public List<Recipents> save(Recipents recipents) {
		recipentsRepository.save(recipents);
		return findAll();
	}

	@Override
	public void updateRecipents(Recipents recipents, long id) {
		recipentsRepository.save(recipents);
	}

	@Override
	public void deleteRecipents(long id) {
		recipentsRepository.deleteById(id);	
	}

	@Override
	public Optional<Recipents> getById(long id) {
		return recipentsRepository.findById(id);
	}

}
