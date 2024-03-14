package com.jspiders.springmvc1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc1.pojo.EmployeePOJO;

@Repository
public class EmployeeRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("springmvc1");
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
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	//Add Employee:=======
	public EmployeePOJO addEmployee(String name,String email,long mobile,String address) {
		openConnection();
		transaction.begin();
		EmployeePOJO pojo = new EmployeePOJO();
		pojo.setName(name);;
		pojo.setEmail(email);
		pojo.setMobile(mobile);
		pojo.setAddress(address);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	//Search Employee:=======
	public EmployeePOJO searchEmployee(int id) {
		openConnection();
		transaction.begin();
		EmployeePOJO employee = manager.find(EmployeePOJO.class, id);
		if (employee != null) {
			transaction.commit();
			closeConnection();
			return employee;
		}
		transaction.commit();
		closeConnection();
		return null;
	}
	
	//Search All Employees:======
	public List<EmployeePOJO> allEmployees() {
		openConnection();
		transaction.begin();
		jpql = "from EmployeePOJO";
		query = manager.createQuery(jpql);
		List<EmployeePOJO> employees = query.getResultList();
		transaction.commit();
		closeConnection();
		return employees;
	}

	//Update Employee:========
	public EmployeePOJO updateEmployee(int id, String name, String email, long mobile, String address) {
		openConnection();
		transaction.begin();
		EmployeePOJO employee = manager.find(EmployeePOJO.class, id);
		employee.setName(name);
		employee.setEmail(email);
		employee.setMobile(mobile);
		employee.setAddress(address);
		manager.persist(employee);
		transaction.commit();
		closeConnection();
		return employee;
	}

	//Remove Employee:=========
	public EmployeePOJO removeEmployee(int id) {
		openConnection();
		transaction.begin();
		EmployeePOJO employee = manager.find(EmployeePOJO.class, id);
		if (employee != null) {
			manager.remove(employee);
			transaction.commit();
			closeConnection();
			return employee;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	
}
