package com.javaimplant.AtomicExample;

import java.util.concurrent.atomic.AtomicInteger;

import com.javaimplant.racecondition.RaceCondition;

public class AtomicIntegerExample implements Runnable {
	private AtomicInteger count = new AtomicInteger();

	@Override
	public synchronized void run() {
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(i * 100);
				count.getAndIncrement();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
	
	public int getCount() {
		return count.get();
	}
	
	public static void main(String[] args) {
		RaceCondition r = new RaceCondition();
		Thread t1 = new Thread(r);
		t1.start();
		
		Thread t2 = new Thread(r);
		t2.start();
		
		Thread t3 = new Thread(r);
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		System.out.println("Count:"+r.getCount());
	}
}
