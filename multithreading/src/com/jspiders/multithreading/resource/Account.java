package com.jspiders.multithreading.resource;

public class Account {

	int accountBalance;
	
	public Account(int accountBalance) {
		this.accountBalance=accountBalance;
	}
    public void checkBalance() {
		System.out.println("current Balance : "+accountBalance);
	}
	public synchronized void depositAmount(int amount) {
		System.out.println("depositing "+amount+"rs in your accoount");
		accountBalance += amount;
		checkBalance();
	}
    public synchronized void withdrawAmount(int amount) {
    	System.out.println("withdrawing "+amount+"rs from your accoount");
		accountBalance -= amount;
		checkBalance();
	}
}
