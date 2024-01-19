package com.jspiders.springmockpraticemvc.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Entity
@Data
public class EmployeePojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int id;
	public String name;
	public String email;

}
