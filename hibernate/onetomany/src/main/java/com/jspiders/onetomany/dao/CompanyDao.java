package com.jspiders.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.dto.Company;
import com.jspiders.onetomany.dto.Employee;

public class CompanyDao {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("company");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null ) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	public static void main(String[] args) {
		
		openConnection();
		transaction.begin();
		
		Company company = new Company();
		company.setId(1);
		company.setName("Infosys");
		company.setEmail("Infosys123@gmail.com");
		
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setName("Suresh");
		employee1.setEmail("suresh123@gmail.com");
		employee1.setSalary(34000);
		
		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("Ramesh");
		employee2.setEmail("ramesh123@gmail.com");
		employee2.setSalary(40000);
		
		Employee employee3 = new Employee();
		employee3.setId(3);
		employee3.setName("Mahesh");
		employee3.setEmail("mahesh123@gmail.com");
		employee3.setSalary(50000);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		
		company.setEmployees(employees);
		
		manager.persist(employee1);
		manager.persist(employee2);
		manager.persist(employee3);
		manager.persist(company);
		
		transaction.commit();
		closeConnection();
	}
}
