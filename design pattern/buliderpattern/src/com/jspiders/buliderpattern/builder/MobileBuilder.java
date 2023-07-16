package com.jspiders.buliderpattern.builder;

import com.jspiders.buliderpattern.object.Mobile;

public class MobileBuilder {

	private String brand, model, colour, os;
	private int ram, memory, disp_res, front_cam, rear_cam;
	private double price, disp_size;

	public MobileBuilder brand(String brand) {
		this.brand = brand;
		return this;
	}

	public MobileBuilder model(String model) {
		this.model = model;
		return this;
	}

	public MobileBuilder colour(String colour) {
		this.colour = colour;
		return this;
	}

	public MobileBuilder os(String os) {
		this.os = os;
		return this;
	}

	public MobileBuilder ram(int ram) {
		this.ram = ram;
		return this;
	}

	public MobileBuilder memory(int memory) {
		this.memory = memory;
		return this;
	}

	public MobileBuilder front_cam(int front_cam) {
		this.front_cam = front_cam;
		return this;
	}

	public MobileBuilder rear_cam(int rear_cam) {
		this.rear_cam = rear_cam;
		return this;
	}

	public MobileBuilder disp_size(double disp_size) {
		this.disp_size = disp_size;
		return this;
	}

	public MobileBuilder price(double price) {
		this.price = price;
		return this;
	}

	public Mobile getMobile() {
		return new Mobile(brand,model,colour,os,price,disp_size,ram,
				memory,disp_res,front_cam,rear_cam);
	}
}
