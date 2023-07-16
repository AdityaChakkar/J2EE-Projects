package com.jspiders.adapterpattern.adapter;

import com.jspiders.adapterpattern.entity.Employee;
import com.jspiders.adapterpattern.entity.Event;

public class EmployeeEventAdapter extends Employee implements Event {

	@Override
	public void womensDay() {
		System.out.println("chief guest of the event is : " + this.name);
		System.out.println("Her Designation is : " + this.designation);
	}
}
