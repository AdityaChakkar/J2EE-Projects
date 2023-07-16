package com.jspiders.singleton.object;

public class SingletonLazy {

	private static SingletonLazy object;
	private static int count;
	
	private SingletonLazy() {
		count++;
		System.out.println("Object Created "+count+" times");
	}
	public static SingletonLazy getObject() {
		System.out.println("Trying to create an object");
		if (object == null) {
			object = new SingletonLazy();
		}
		return object;
	}
}
