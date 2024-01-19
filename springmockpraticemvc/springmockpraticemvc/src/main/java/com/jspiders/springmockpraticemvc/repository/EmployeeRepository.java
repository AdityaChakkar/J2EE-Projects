package com.jspiders.springmockpraticemvc.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jspiders.springmockpraticemvc.pojo.EmployeePojo;

@Repository
public class EmployeeRepository {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private javax.persistence.Query query;
	private String jpql;
	
	
	public void openConnection() {
	  factory = Persistence.createEntityManagerFactory("mvcpratice");
	  manager = factory.createEntityManager();
	  transaction= manager.getTransaction();
	}
	
	public void closeConnection() {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {
			manager.close();
		}
		
		if(transaction.isActive()) {
			transaction.rollback();
		
		}
	}
	public EmployeePojo addEmployee(String name,String email) {
		openConnection();
		transaction.begin();
		EmployeePojo employee = new EmployeePojo();
		employee.setName(name);
		employee.setEmail(email);
		transaction.commit();
		closeConnection();
		return employee;
		}
	}

