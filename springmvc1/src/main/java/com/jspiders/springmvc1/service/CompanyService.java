package com.jspiders.springmvc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc1.pojo.CompanyPOJO;
import com.jspiders.springmvc1.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository repository;

	public CompanyPOJO login(String username, String password) {
		CompanyPOJO pojo = repository.login(username,password);
		return pojo;
	}

	public List<CompanyPOJO> getCompany() {
		List<CompanyPOJO> pojo = repository.getCompany();
		return pojo;
	}

	public CompanyPOJO addAdmin(String username, String password) {
		CompanyPOJO pojo = repository.addCompany(username, password);
		return pojo;
	}

}
