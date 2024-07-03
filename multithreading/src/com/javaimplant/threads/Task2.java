package com.javaimplant.threads;

public class Task2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Task2 Started");
		for(int i=201;i<=299;i++) {
			System.out.print(i+" ");
		}
		System.out.println("Task2 Done");

	}

}
