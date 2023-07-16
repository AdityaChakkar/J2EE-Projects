package com.jspiders.hibernateonetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetoone.dto.AadharDTO;
import com.jspiders.hibernateonetoone.dto.PersonDTO;

public class PersonAadharDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("OneToOne");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	private static void closeConnection() {
		if (factory !=null) {
			factory.close();
		}
		if (manager!=null) {
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
			
			AadharDTO aadhar1 = new AadharDTO();
			aadhar1.setId(1);
			aadhar1.setAadhar_no(592443980263l);
			aadhar1.setDoi("01-01-2003");
			
			
			PersonDTO person1 = new PersonDTO();
			person1.setId(1);
			person1.setName("Aditya");
			person1.setContact(9112740106l);
			person1.setDob("22-05-2001");
			person1.setAddress("Pune");
			
			person1.setAadhar(aadhar1);
			manager.persist(person1);
			aadhar1.setPerson(person1);
			manager.persist(aadhar1);
			
			transaction.commit();
			
		} finally {
			closeConnection();
		}
	}
}
