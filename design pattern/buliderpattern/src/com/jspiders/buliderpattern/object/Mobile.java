package com.jspiders.buliderpattern.object;

public class Mobile {

	private String brand, model, colour, os;
	private double price, disp_size;
	private int ram, memory, disp_res, front_cam, rear_cam;

	public Mobile(String brand, String model, String colour, String os, double price, double disp_size, int ram,
			int memory, int disp_res, int front_cam, int rear_cam) {
		super();
		this.brand = brand;
		this.model = model;
		this.colour = colour;
		this.os = os;
		this.price = price;
		this.disp_size = disp_size;
		this.ram = ram;
		this.memory = memory;
		this.disp_res = disp_res;
		this.front_cam = front_cam;
		this.rear_cam = rear_cam;
	}

	@Override
	public String toString() {
		return "Mobile [brand=" + brand + ", model=" + model + ", colour=" + colour + ", os=" + os + ", price=" + price
				+ ", disp_size=" + disp_size + ", ram=" + ram + ", memory=" + memory + ", disp_res=" + disp_res
				+ ", front_cam=" + front_cam + ", rear_cam=" + rear_cam + "]";
	}
}
