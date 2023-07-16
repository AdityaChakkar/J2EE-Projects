package com.jspiders.adapterpattern.main;

import com.jspiders.adapterpattern.adapter.EmployeeEventAdapter;

public class AdapterMain {

	public static void main(String[] args) {
		
		EmployeeEventAdapter adapter = new EmployeeEventAdapter();
		adapter.id = 1;
		adapter.name = "Sara";
		adapter.email = "sara@gmail.com";
		adapter.contact = 8767676865L;
		adapter.designation = "Frontend Developer";
		
		adapter.womensDay();
	}
}
