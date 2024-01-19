package com.jspiders.hibernate1.employeedto;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "teacher_details")
public class TeacherDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tid")
	private int id;
	@Column(name = "tname")
	private String name;
	@Column(name = "sub")
	private String subject;
	@Column(name = "months")
	private int duration;
}
