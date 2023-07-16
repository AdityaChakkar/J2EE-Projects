package com.jspiders.factory.cars;

import com.jspiders.factory.interfaces.Car;

public class Harrier implements Car {

	@Override
	public void buyCar() {
		System.out.println("Bought Harrier");
	}

}
