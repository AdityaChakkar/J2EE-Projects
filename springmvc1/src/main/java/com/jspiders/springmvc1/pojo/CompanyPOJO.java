package com.jspiders.springmvc1.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CompanyMVC")
public class CompanyPOJO {
	
	@Id
	private String username;
	private String password;

}
