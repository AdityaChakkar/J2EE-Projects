package com.jspiders.springrest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springrest.pojo.StudentPojo;

@Repository
public class StudentRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("rest");
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

	public StudentPojo addStudent(StudentPojo pojo) {
		openConnection();
		transaction.begin();
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public StudentPojo searchStudent(int id) {
		openConnection();
		transaction.begin();
		StudentPojo student = manager.find(StudentPojo.class, id);
		if (student != null) {
			transaction.commit();
			closeConnection();
			return student;
		}
		transaction.commit();
		closeConnection();
		return null;
	}
	public List<StudentPojo> searchAllStudents() {
		openConnection();
		transaction.begin();
		jpql = "from StudentPojo";
		query = manager.createQuery(jpql);
		List<StudentPojo> students = query.getResultList();
		transaction.commit();
		closeConnection();
		return students;
		
	}
	
	
}
