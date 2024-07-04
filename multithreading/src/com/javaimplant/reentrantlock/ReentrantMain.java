package com.javaimplant.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantMain {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		ExecutorService singleexecutorService = Executors.newSingleThreadExecutor();
		singleexecutorService.execute(new ReentrantTask(lock,1));
		singleexecutorService.execute(new ReentrantTask(lock,2));
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new ReentrantTask(lock,3));
		executorService.execute(new ReentrantTask(lock,4));
		executorService.execute(new ReentrantTask(lock,5));
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new ReentrantTask(lock,6), 0, 1, TimeUnit.SECONDS);
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new ReentrantTask(lock,7), 0, 1, TimeUnit.SECONDS);
		executorService.shutdown();
	}

}
