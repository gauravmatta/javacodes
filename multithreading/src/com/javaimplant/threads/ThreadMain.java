package com.javaimplant.threads;

public class ThreadMain {

	public static void main(String[] args) {
		Task1 t1=new Task1();
		t1.start();
		Task2 t2 = new Task2();
		new Thread(t2).start();
	}
}
