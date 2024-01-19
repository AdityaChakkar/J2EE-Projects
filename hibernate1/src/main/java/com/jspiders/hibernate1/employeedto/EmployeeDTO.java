package com.jspiders.hibernate1.employeedto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EmployeeDTO {

	@Id
	private int eid;
	private String ename;
	private String email;
	private int sal;
	private String address;
}
