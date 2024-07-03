package com.javaimplant.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.javaimplant.threads.CallableTask;

public class CallableRunner {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> welcomeFuture = executorService.submit(new CallableTask("Java Implant"));
		System.out.println("Callable Executed");
		
		try {
			System.out.println("Response From Callable"+welcomeFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		System.out.println("Main Completed");
		

	}

}
