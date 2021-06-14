package com.simplilearn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.domain.Recipents;
import com.simplilearn.service.RecipentsService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
public class RecipientController {

	@Autowired
	private RecipentsService recipentsService;

	@RequestMapping(path = "/addrecipients/{userId}", method = RequestMethod.POST)
	public String save(@RequestBody Recipents recipents, @PathVariable("userId") long userId) {
		return recipentsService.save(recipents, userId);
	}

	@GetMapping("/recipentsByUserId/{userId}")
	public List<Recipents> getRecipentsByUserId(@PathVariable("userId") long id) {
		return recipentsService.getByUserId(id);
	}

	@RequestMapping(path = "/recipents/{id}", method = RequestMethod.DELETE)
	public void deleteRecipents(@PathVariable("id") long id) {
		recipentsService.deleteRecipents(id);
	}

	@RequestMapping(path = "/updaterecipents", method = RequestMethod.PUT)

	public Recipents update(@RequestBody Recipents recipents, long id) {
		recipentsService.updateRecipents(recipents, id);
		return recipents;
	}

	@GetMapping("/recipents/{id}")
	public Optional<Recipents> getRecipentsById(@PathVariable("id") long id) {
		return recipentsService.getById(id);
	}

	@GetMapping("/recipents")
	public List<Recipents> getAllRecipents(@PathVariable("id") long id) {
		return recipentsService.findAll();
	}

}
