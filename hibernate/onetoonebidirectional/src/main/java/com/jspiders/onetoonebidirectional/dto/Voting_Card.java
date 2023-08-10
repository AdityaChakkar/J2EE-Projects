package com.jspiders.onetoonebidirectional.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Voting_Card {

	@Id
	private int id;
	private String card_No;
	private String doI;
	@OneToOne (mappedBy = "card")
	private Voter voter;
}
