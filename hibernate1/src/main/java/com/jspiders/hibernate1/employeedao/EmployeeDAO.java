package com.jspiders.hibernate1.employeedao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.employeedto.EmployeeDTO;

public class EmployeeDAO {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		EmployeeDTO dto = new EmployeeDTO();
		dto.setEid(5);
		dto.setEname("Tejas");
		dto.setEmail("tejas123@gmail.com");
		dto.setSal(35000);
		dto.setAddress("Pune");

		entityManager.persist(dto);
		entityTransaction.commit();

		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
	}
}
