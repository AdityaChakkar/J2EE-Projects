package com.jspiders.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest.pojo.StudentPojo;
import com.jspiders.springrest.responce.StudentResponce;
import com.jspiders.springrest.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping(path = "/add",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponce> addStudent(@RequestBody StudentPojo pojo) {
		StudentPojo student = service.addStudent(pojo);
		StudentResponce responce = new StudentResponce();
		// success flow
		if (student != null) {
			responce.setMessage("Data inserted successfully. ");
			responce.setData(student);
			return new ResponseEntity<StudentResponce>(responce, HttpStatus.ACCEPTED);
		}
		// failure flow
		responce.setMessage("Data not inserted");
		return new ResponseEntity<StudentResponce>(responce, HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponce> search(@RequestBody StudentPojo pojo) {
		StudentPojo student = service.searchStudent(pojo.getId());
		// Success flow
		if (student != null) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data found successfully. ", student, null),
					HttpStatus.FOUND);
		}
		// Failure flow
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data does not exist. ", null, null),
				HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/searchAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponce> searchAllStudents() {
		List<StudentPojo> students = service.searchAllStudents();
		if (students != null) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data found successfully. ", null, students),
					HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponce>(new StudentResponce("No student data found. ", null, null),
				HttpStatus.NOT_FOUND);
	}
}
