package com.javaimplant.synchronize;

public class ResourceCaller {

	public static void main(String[] args) {
		Resource resource = new Resource();
		Thread t1=new Thread(resource::process);
		Thread t2=new Thread(resource::setDisallow);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		System.out.println("Program Terminted");
	}

}
