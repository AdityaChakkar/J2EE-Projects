package com.jspiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.dto.Player;
import com.jspiders.manytoone.dto.Team;

public class PlayerTeam {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("ManyToOne");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null ) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	public static void main(String[] args) {
		openConnection();
		transaction.begin();
		
		Team team = new Team();
		team.setId(1);
		team.setName("T20");
		team.setCountry("India");
		
		Player p1 = new Player();
		p1.setId(1);
		p1.setName("Virat");
		p1.setJersey_No(18);
		p1.setAge(34);
		p1.setTeam(team);
		
		Player p2 = new Player();
		p2.setId(2);
		p2.setName("Rohit");
		p2.setJersey_No(45);
		p2.setAge(36);
		p2.setTeam(team);
		
		Player p3 = new Player();
		p3.setId(3);
		p3.setName("MS-Dhoni");
		p3.setJersey_No(7);
		p3.setAge(40);
		p3.setTeam(team);
		
		manager.persist(team);
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		
		transaction.commit();
		closeConnection();
	}
}
