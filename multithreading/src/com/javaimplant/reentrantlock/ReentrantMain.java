package com.javaimplant.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantMain {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new ReentrantTask(lock,1));
		executorService.execute(new ReentrantTask(lock,3));
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new ReentrantTask(lock,2), 0, 1, TimeUnit.SECONDS);
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new ReentrantTask(lock,4), 0, 1, TimeUnit.SECONDS);
		executorService.shutdown();
	}

}
