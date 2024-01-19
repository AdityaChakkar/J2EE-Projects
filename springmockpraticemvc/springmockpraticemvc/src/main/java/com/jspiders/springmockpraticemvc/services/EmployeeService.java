package com.jspiders.springmockpraticemvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmockpraticemvc.pojo.EmployeePojo;
import com.jspiders.springmockpraticemvc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public EmployeePojo addEmployee(String name, String email) throws Exception {

		if (email.contains("@")) {
			EmployeePojo pojo = repository.addEmployee(name, email);
			return pojo;
		} else {
			throw new InvalidEmailException();
		}

	}
}
