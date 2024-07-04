package com.javaimplant.reentrantlock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantMain {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<String> result = executorService.submit(new ReentrantTask(lock,1));
		try {
			String s = result.get();
			System.out.println("Response:"+s);
		} catch (ExecutionException| InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

}
