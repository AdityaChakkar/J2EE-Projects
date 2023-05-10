package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resource.Bike;

public class BikeUser1 extends Thread{

	Bike bike;

	public BikeUser1(Bike bike) {
		this.bike = bike;
	}
	
	@Override
	public void run() {
		synchronized (bike.bike1) {
			System.out.println(this.getName() + " is sitting on a " + bike.bike1);
			synchronized (bike.Key) {
				System.out.println(this.getName() + " has a " + bike.Key);
			}
			System.out.println(this.getName() + " give it to another the " + bike.Key);
		}
		System.out.println(this.getName() + " give it to another the " + bike.bike1);
	}
}
