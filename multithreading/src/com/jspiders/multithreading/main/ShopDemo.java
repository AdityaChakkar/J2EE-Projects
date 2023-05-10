package com.jspiders.multithreading.main;

import java.util.Iterator;

public class ShopDemo {

	public static void main(String[] args) {
		String msg = "This is the execution of sleep() method";
		for (int i = 0; i < msg.length(); i++) {
			System.out.print(msg.charAt(i));
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
