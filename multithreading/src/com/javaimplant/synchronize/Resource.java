package com.javaimplant.synchronize;

import java.util.concurrent.atomic.AtomicBoolean;

public class Resource {
	private AtomicBoolean disallow = new AtomicBoolean(false);
	
	public synchronized void setDisallow() {
		disallow.set(true);
		System.out.println(Thread.currentThread().getName()+": Processing is disallowed now");
	}
	
	public synchronized void process() {
		if(!disallow.get()) {
			try {
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName()+" : I processed because it was allowed :"+disallow.get());
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName()+" : I could not process because it was not allowed");
		}
	}
	
	public static synchronized void method1() {
		System.out.println("Method 1 called");
	}
	public static synchronized void method2() {
		System.out.println("Method 2 called");
	}
	public static void method3() {
		System.out.println("Method 3 called");
	}
	public synchronized void method4() {
		System.out.println("Method 4 called");
	}
	public void method5() {
		System.out.println("Method 5 called");
	}
}
