package com.jspiders.springmvc.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PersonPOJO {

	@Id
	private String name;
}
