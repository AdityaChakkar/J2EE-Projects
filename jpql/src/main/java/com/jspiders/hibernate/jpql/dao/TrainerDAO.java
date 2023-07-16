package com.jspiders.hibernate.jpql.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernate.jpql.dto.TrainerDTO;



public class TrainerDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory(jpql);
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
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();
			
			
			/*
			 * TrainerDTO t1 = new TrainerDTO(); t1.setName("Ajay"); t1.setSubject("SQL");
			 * t1.setEmail("ajay@gmail.com"); manager.persist(t1);
			 * 
			 * TrainerDTO t2 = new TrainerDTO(); t2.setName("Akash");
			 * t2.setSubject("Core Java"); t2.setEmail("akash@gmail.com");
			 * manager.persist(t2);
			 * 
			 * TrainerDTO t3 = new TrainerDTO(); t3.setName("Dhananjay");
			 * t3.setSubject("Advance Java"); t3.setEmail("danny@gmail.com");
			 * manager.persist(t3);
			 * 
			 * TrainerDTO t4 = new TrainerDTO(); t4.setName("Abhijeet");
			 * t4.setSubject("WebTech"); t4.setEmail("abhijeet@gmail.com");
			 * manager.persist(t4);
			 * 
			 * TrainerDTO t5 = new TrainerDTO(); t5.setName("Sushant");
			 * t5.setSubject("Programming"); t5.setEmail("sushant@gmail.com");
			 * manager.persist(t5);
			 */
			
			jpql = "from TrainerDTO";
			query = manager.createQuery(jpql);
			
			List<TrainerDTO> trainers = query.getResultList();
			
			for (TrainerDTO trainer : trainers) {
				System.out.println(trainer);
			}
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
}
