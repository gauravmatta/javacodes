package com.javaimplant.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.javaimplant.threads.Task1;
import com.javaimplant.threads.Task2;

public class ExecutorServiceSingleThreadRunner {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new Task1());
		executorService.execute(new Thread(new Task2()));
		executorService.execute(new Task2());
		System.out.println("Task3 Kicked off");
		for(int i=301;i<=399;i++) {
			System.out.print(i+" ");
		}
		System.out.println("Task3 Done");
		System.out.println("Main Done");
		executorService.shutdown();
	}

}
