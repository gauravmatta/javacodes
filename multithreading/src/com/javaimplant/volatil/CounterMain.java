package com.javaimplant.volatil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CounterMain {

	public static void main(String[] args) {
		ExecutorService executorService = null;
		Counter counter = new Counter();
		try {
			executorService= Executors.newFixedThreadPool(2);
			Runnable task1 = ()->{
				for(int i=1;i<=20000;i++) {
					counter.increment();
				}
			};
			Runnable task2 = ()->{
				for(int i=1;i<=80000;i++) {
					counter.increment();
				}
			};
			executorService.submit(task1);
			executorService.submit(task2);
			executorService.awaitTermination(1,TimeUnit.SECONDS);
			System.out.println("Final Counter Value:"+counter.getValue());
		}catch (Exception e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}finally {
			if(executorService != null) {
				executorService.shutdown();
			}
		}
		
	}

}
