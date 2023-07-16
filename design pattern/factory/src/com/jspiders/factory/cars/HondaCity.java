package com.jspiders.factory.cars;

import com.jspiders.factory.interfaces.Car;

public class HondaCity implements Car{

	@Override
	public void buyCar() {
		System.out.println("Bought HondaCity");
	}
}
