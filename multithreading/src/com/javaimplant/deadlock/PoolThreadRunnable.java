package com.javaimplant.deadlock;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable {
	
	private Thread thread = null;
	private BlockingQueue<Runnable> taskQueue = null;
	private Boolean isStoppedBoolean = false;
	
	public PoolThreadRunnable(BlockingQueue<Runnable> queue) {
		taskQueue=queue;
	}

	@Override
	public void run() {
		this.thread = Thread.currentThread();
		while(!isStopped()) {
				try {
					Runnable runnable = (Runnable) taskQueue.take();
					runnable.run();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	public synchronized void doStop() {
		isStoppedBoolean = true;
		this.thread.interrupt();
	}

	private synchronized boolean isStopped() {
		return isStoppedBoolean;
	}

}
