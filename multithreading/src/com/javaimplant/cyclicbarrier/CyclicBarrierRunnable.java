package com.javaimplant.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRunnable implements Runnable {
	
	CyclicBarrier barrier;
	private int number;
	
	public CyclicBarrierRunnable(CyclicBarrier latch,int number) {
		this.barrier=latch;
		this.number=number;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Task "+number+ " Started");
		for(int i=number*100;i<=number*100+99;i++) {
			System.out.print(i+" ");
		}
		System.out.println("After "+Thread.currentThread().getName()+" Total Threads Waiting are  :"+ barrier.getNumberWaiting());
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" released");
	}
	
}
