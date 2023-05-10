package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.Bike;
import com.jspiders.multithreading.threads.BikeUser1;
import com.jspiders.multithreading.threads.BikeUser2;

public class BikeMain {
	public static void main(String[] args) {
		Bike bike = new Bike();
		
		BikeUser1 bikeuser1 = new BikeUser1(bike);
		bikeuser1.setName("User1");
		
		BikeUser2 bikeuser2 = new BikeUser2(bike);
		bikeuser2.setName("User2");
		
		bikeuser1.start();
		bikeuser2.start();
	}	
}
