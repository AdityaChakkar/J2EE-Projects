package com.jspiders.springmvc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc1.pojo.EmployeePOJO;
import com.jspiders.springmvc1.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public EmployeePOJO addEmployee(String name,String email,long mobile,String address) {
		EmployeePOJO pojo = repository.addEmployee(name, email, mobile, address);
		return pojo;
	}

	public EmployeePOJO searchEmployee(int id) {
		EmployeePOJO pojo = repository.searchEmployee(id);
		return pojo;
	}

	public EmployeePOJO updateEmployee(int id, String name, String email, long mobile, String address) {
		EmployeePOJO pojo = repository.updateEmployee(id,name,email,mobile,address);
		return pojo;
	}

	public List<EmployeePOJO> allEmployees() {
		List<EmployeePOJO> employees = repository.allEmployees();
		return employees;
	}

	public EmployeePOJO removeEmployee(int id) {
		EmployeePOJO employee = repository.removeEmployee(id);
		return employee;
	}
}
