package com.javaimplant.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.javaimplant.threads.Task;
import com.javaimplant.threads.Task1;
import com.javaimplant.threads.Task2;

public class ExecutorServiceCachedThreadRunner {

	public static void main(String[] args) {
		ThreadFactory factory = new  ThreadFactory() {
			private int threadCount =1;
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setName("JavaImplant"+threadCount++);
				return thread;
			}
		};
		ExecutorService executorService = Executors.newCachedThreadPool(factory);
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
