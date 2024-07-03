package com.javaimplant.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.javaimplant.threads.Task;
import com.javaimplant.threads.Task1;
import com.javaimplant.threads.Task2;

public class ExecutorServiceFixedThreadRunner {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.execute(new Thread(new Task(1)));
		executorService.execute(new Thread(new Task(2)));
		executorService.execute(new Thread(new Task(3)));
		executorService.execute(new Thread(new Task(4)));
		executorService.execute(new Thread(new Task(5)));
		executorService.execute(new Thread(new Task(6)));
		executorService.execute(new Thread(new Task(7)));
		executorService.shutdown();
	}

}
