package com.javaimplant.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class LatchMain {

	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Thread(new CountDownLatchRunnable(countDownLatch,1)));
		executorService.execute(new Thread(new CountDownLatchRunnable(countDownLatch,2)));
		executorService.execute(new Thread(new CountDownLatchRunnable(countDownLatch,3)));
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		executorService.execute(new Thread(new CountDownLatchRunnable(countDownLatch,4)));
		executorService.execute(new Thread(new CountDownLatchRunnable(countDownLatch,5)));
		executorService.execute(new Thread(new CountDownLatchRunnable(countDownLatch,6)));
		executorService.execute(new Thread(new CountDownLatchRunnable(countDownLatch,7)));

	}

}
