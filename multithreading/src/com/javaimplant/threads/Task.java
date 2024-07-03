package com.javaimplant.threads;

public class Task extends Thread {
	private int number;
	public Task(int number) {
		this.number=number;
	}
	public void run() {
		System.out.println("Task "+number+ "Started");
		for(int i=number*100;i<=number*100+99;i++) {
			System.out.print(i+" ");
		}
		System.out.println("Task "+number+ "Done");
	}
}
