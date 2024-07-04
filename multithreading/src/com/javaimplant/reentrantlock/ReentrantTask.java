package com.javaimplant.reentrantlock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTask implements Callable<String> {

	ReentrantLock lock;
	private int number;
	
	public ReentrantTask(ReentrantLock lock,int number) {
		this.lock=lock;
		this.number=number;
	}
	
	@Override
	public String call() throws Exception {
		lock.lock();
		try {
		System.out.println("Locked :"+lock.isLocked());
		System.out.println("Held by this thread: "+lock.isHeldByCurrentThread());
		boolean locked = lock.tryLock();
		System.out.println("Lock acquired");
		System.out.println(Thread.currentThread().getName()+" Task "+number+ "Started");
		for(int i=number*100;i<=number*100+99;i++) {
			System.out.print(i+" ");
		}
		System.out.println(Thread.currentThread().getName()+ "Task "+number+ "Done");
		return "Hello" + Thread.currentThread().getName()+"is Finished";
		} finally {
			lock.unlock();
		}
	}

}
