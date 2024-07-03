package com.javaimplant.deadlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
	
	private BlockingQueue<Runnable> taskQueue = null;
	private List<PoolThreadRunnable> runnables = new ArrayList<>();
	private Boolean isStoppedBoolean = false;
	
	public ThreadPool(int noOfThreads, int noOfTasks) {
		taskQueue = new ArrayBlockingQueue<Runnable>(noOfTasks);
		
		for(int i=0;i<noOfThreads;i++) {
			PoolThreadRunnable  poolThreadRunnable = new PoolThreadRunnable(taskQueue);
			runnables.add(poolThreadRunnable);
		}
		
		for(PoolThreadRunnable runnable:runnables) {
			new Thread(runnable).start();
		}
	}
	
	public synchronized void execute(Runnable task) throws Exception{
		if(this.isStoppedBoolean) throw
				new IllegalStateException("ThreadPool is stopped");
		this.taskQueue.offer(task);
	}
	
	public synchronized void stop() {
		this.isStoppedBoolean=true;
		for(PoolThreadRunnable runnable: runnables) {
			runnable.doStop();
		}
	}
	
	public synchronized void waitUntillAllTasksFinished() {
		while(this.taskQueue.size() > 0) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}