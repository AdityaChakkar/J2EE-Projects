package com.jspiders.manytomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.dto.Student;
import com.jspiders.manytomany.dto.Subject;

public class StudentSubject {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("ManyToMany");
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
	
	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();
			
			Subject s1 = new Subject();
			s1.setId(1);
			s1.setName("CoreJava");
			s1.setFees(4000);
			
			Subject s2 = new Subject();
			s2.setId(2);
			s2.setName("SQL");
			s2.setFees(2000);
			
			Subject s3 = new Subject();
			s3.setId(3);
			s3.setName("J2EE");
			s3.setFees(6000);
			
			Student student1 = new Student(); 
			student1.setId(1);
			student1.setName("Rushikesh");
			student1.setEmail("rushikesh123@gmail.com");
			student1.setContact(6857456545l);
			
			Student student2 = new Student(); 
			student2.setId(2);
			student2.setName("Aditya");
			student2.setEmail("aditya123@gmail.com");
			student2.setContact(5676586575l);
			
			Student student3 = new Student(); 
			student3.setId(3);
			student3.setName("Pranav");
			student3.setEmail("pranav123@gmail.com");
			student3.setContact(9876543210l);
			
			
			List<Subject> subjects = new ArrayList<>();
			subjects.add(s1);
			subjects.add(s2);
			subjects.add(s3);
			
			student1.setSubjects(subjects);
			student2.setSubjects(subjects);
			student3.setSubjects(subjects);
			
			
			manager.persist(student1);
			manager.persist(student2);
			manager.persist(student3);
			manager.persist(s1);
			manager.persist(s2);
			manager.persist(s3);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}
}
