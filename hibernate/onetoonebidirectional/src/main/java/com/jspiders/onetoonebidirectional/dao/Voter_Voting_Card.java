package com.jspiders.onetoonebidirectional.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoonebidirectional.dto.Voter;
import com.jspiders.onetoonebidirectional.dto.Voting_Card;

public class Voter_Voting_Card {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("One2OneBidirection");
		manager  = factory.createEntityManager();
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
			
			Voter voter = new Voter();
			voter.setId(1);
			voter.setName("Rushikesh");
			voter.setAddress("Pune");
			
			Voter voter2 = new Voter();
			voter2.setId(2);
			voter2.setName("Aditya");
			voter2.setAddress("Pune");
			
			Voting_Card card = new Voting_Card();
			card.setId(1);
			card.setCard_No("Afdjg235D");
			card.setDoI("02-jul-2017");
			card.setVoter(voter);
			
			Voting_Card card1 = new Voting_Card();
			card1.setId(2);
			card1.setCard_No("FsDGM53F");
			card1.setDoI("12-jul-2018");
			card1.setVoter(voter2);
			
			voter.setCard(card);
			voter2.setCard(card1);
			
			manager.persist(voter);
			manager.persist(voter2);
			manager.persist(card1);
			manager.persist(card);
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}
}
