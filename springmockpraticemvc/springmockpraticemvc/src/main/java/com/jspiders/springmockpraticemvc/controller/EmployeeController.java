package com.jspiders.springmockpraticemvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmockpraticemvc.pojo.EmployeePojo;
import com.jspiders.springmockpraticemvc.services.EmployeeService;
import com.jspiders.springmockpraticemvc.services.InvalidEmailException;


@Controller
public class EmployeeController {
	
	@Autowired
	public EmployeeService service;
	
	@GetMapping("/addemployee")
	public String Add() {
		return "AddEmployee";
	}
	
	
	@PostMapping("/addemployee")
	public String addEmployee(@RequestParam String name,@RequestParam String email,ModelMap map) throws Exception {
		
		EmployeePojo pojo;
		try {
			pojo = service.addEmployee(name,email);
			if(pojo!=null) {
				map.addAttribute("employee", pojo);
				map.addAttribute("msg", "Employee Data Added successfully");
				return "AddEmployee";
				}
		} catch (InvalidEmailException e) {
			System.out.println("Invalid Email...!! Try Again");
			e.printStackTrace();
		}
			
		
		map.addAttribute("msg", "Invalid email.... Try Again");
		return "AddEmployee";
	}
	

}
