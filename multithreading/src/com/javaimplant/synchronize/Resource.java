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
}
