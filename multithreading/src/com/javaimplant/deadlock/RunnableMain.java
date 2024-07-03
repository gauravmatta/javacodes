package com.javaimplant.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RunnableMain {

	public static void main(String[] args) throws Exception {
		ExecutorService executorService= Executors.newFixedThreadPool(5);
		for(int i=0;i<=10;i++) {
			Runnable runnable=new MyRunnable("myWorkerThread"+i);
			executorService.execute(runnable);
		}
		executorService.shutdown();
		
		while(!executorService.isTerminated()) {
			System.out.println("All requests completed Successfully");
		}
		
		
		//Custom Thread Pool Implementation Example
		ThreadPool threadPool = new ThreadPool(3, 10);
		for(int i=0;i<10;i++) {
			int taskNo = i;
			threadPool.execute(() -> {
				String msgString = Thread.currentThread().getName()+": " + taskNo;
				System.out.println(msgString);
			});
		}
		
		threadPool.waitUntillAllTasksFinished();
		threadPool.stop();
		//Custom Thread Pool Implementation Example
	}

}
