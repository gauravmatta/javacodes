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
		
		Thread t3 = new Thread(Resource::method1);
		Thread t4 = new Thread(Resource::method2);
		Thread t5 = new Thread(Resource::method3);
		Thread t6 = new Thread(()->{
			Resource r =new Resource();
			r.method4();
		});
		Thread t7 = new Thread(()->{
			Resource r =new Resource();
			r.method5();
		});
		
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		System.out.println("Program Terminted");
		
		
	}

}
