package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resource.Bike;

public class BikeUser2 extends Thread {

	Bike bike;

	public BikeUser2(Bike bike) {
		this.bike = bike;
	}
	
	@Override
	public void run() {
		synchronized (bike.Key) {
			System.out.println(this.getName() + " has a " + bike.Key);
			synchronized (bike.bike1) {
				System.out.println(this.getName() + " is sitting on a " + bike.bike1);
			}
			System.out.println(this.getName() + " give it to a " + bike.bike1);
		}
		System.out.println(this.getName() + " give it to a " + bike.Key);
	}
}
