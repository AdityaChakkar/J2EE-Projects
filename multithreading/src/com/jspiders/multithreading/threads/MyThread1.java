package com.jspiders.multithreading.threads;

public class MyThread1 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i <=10; i++) {
			System.out.println(this.getName()+" is Running");
			System.out.println(this.getPriority()+ " is priority of the thread");
		}
	}
}
