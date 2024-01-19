package com.jspiders.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.PersonPOJO;

@Repository
public class PersonRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("mvc");
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
	
	public PersonPOJO addPerson(String name) {
		openConnection();
		transaction.begin();
		PersonPOJO pojo = new PersonPOJO();
		pojo.setName(name);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}
	
	public List<PersonPOJO> allPersons(String name) {
		openConnection();
		transaction.begin();
		jpql="from PersonPOJO where name like '%"+name+"'";
		query = manager.createQuery(jpql);
		List<PersonPOJO> persons = query.getResultList();
		transaction.commit();
		closeConnection();
		return persons;
	}
}
