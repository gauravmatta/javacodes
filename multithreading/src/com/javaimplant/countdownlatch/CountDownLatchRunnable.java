package com.javaimplant.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchRunnable implements Runnable {
	
	CountDownLatch countDownLatch;
	private int number;
	
	public CountDownLatchRunnable(CountDownLatch latch,int number) {
		this.countDownLatch=latch;
		this.number=number;
	}

	@Override
	public void run() {
		System.out.println("\n"+Thread.currentThread().getName()+" Task "+number+ "Started");
		for(int i=number*100;i<=number*100+99;i++) {
			System.out.print(i+" ");
		}
		countDownLatch.countDown();
		System.out.println("\n"+Thread.currentThread().getName()+" has reduced latch count to :"+ countDownLatch.getCount());
	}
	
}
