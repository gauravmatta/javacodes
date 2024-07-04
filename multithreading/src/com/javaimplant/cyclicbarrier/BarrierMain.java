package com.javaimplant.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.javaimplant.threads.Task;


public class BarrierMain {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Thread(new CyclicBarrierRunnable(barrier,1)));
		executorService.execute(new Thread(new CyclicBarrierRunnable(barrier,2)));
		executorService.execute(new Thread(new CyclicBarrierRunnable(barrier,3)));
		executorService.execute(new Thread(new Task(4)));
		executorService.execute(new Thread(new Task(5)));
		executorService.execute(new Thread(new Task(6)));
		executorService.shutdown();
	}

}
