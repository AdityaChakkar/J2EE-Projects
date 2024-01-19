package com.jspiders.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.pojo.PersonPOJO;
import com.jspiders.springmvc.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public PersonPOJO addPerson(String name) {
		PersonPOJO pojo = repository.addPerson(name);
		return pojo;
	}
	
	public List<PersonPOJO> allPersons(String name){
		List<PersonPOJO> persons = repository.allPersons(name);
		return persons;
	}
}
