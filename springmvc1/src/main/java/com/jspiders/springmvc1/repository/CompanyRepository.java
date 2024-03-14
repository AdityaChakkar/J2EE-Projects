package com.jspiders.springmvc1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc1.pojo.CompanyPOJO;

@Repository
public class CompanyRepository {

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

	//Add Company Details:------
	public CompanyPOJO addCompany(String username, String password) {
		openConnection();
		transaction.begin();
		CompanyPOJO company = new CompanyPOJO();
		company.setUsername(username);
		company.setPassword(password);
		manager.persist(company);
		transaction.commit();
		closeConnection();
		return company;
	}

	
	//Company Login :------
	public CompanyPOJO login(String username, String password) {
		openConnection();
		transaction.begin();
		jpql = "From CompanyPOJO "
				+ "where username = '" + username + "' "
				+ "and password = '" + password + "'";
		query = manager.createQuery(jpql);
		CompanyPOJO pojo = (CompanyPOJO) query.getSingleResult();
		if (pojo != null) {
			transaction.commit();
			closeConnection();
			return pojo;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public List<CompanyPOJO> getCompany() {
		openConnection(); 
		transaction.begin();
		jpql = "from CompanyPOJO";
		query = manager.createQuery(jpql);
		List<CompanyPOJO> company = query.getResultList();
		transaction.commit();
		closeConnection();
		return company;
	}

}
