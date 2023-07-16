package com.jspiders.factory.main;

import java.util.Scanner;

import com.jspiders.factory.cars.Harrier;
import com.jspiders.factory.cars.HondaCity;
import com.jspiders.factory.cars.Nexon;
import com.jspiders.factory.cars.XUV700;
import com.jspiders.factory.interfaces.Car;

public class CarFactory {
	public static Car car;
	
	public static void main(String[] args) {
		try {
			factory().buyCar();
		} catch (NullPointerException e) {
			System.out.println("No Car Selected");
		}
	}
	private static Car factory() {
		System.out.println("Car Purchase Option\n"
							+ "1.Harrier\n"
							+ "2.Nexon\n"
							+ "3.XUV700\n"
							+ "4.HondaCity");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			car = new Harrier();
			break;
		case 2:
			car = new Nexon();
			break;
		case 3:
			car = new XUV700();
			break;
		case 4:
			car = new HondaCity();
			break;

		default:
			System.out.println("Invalid Choice");
			System.out.println("Please select correct one.");
			break;
		}
		sc.close();
		return car;	
	}
}
