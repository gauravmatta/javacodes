package com.javaimplant.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTask implements Runnable {

	ReentrantLock lock;
	private int number;
	
	public ReentrantTask(ReentrantLock lock,int number) {
		this.lock=lock;
		this.number=number;
	}
	
	@Override
	public void run()  {
		System.out.println("Locked :"+lock.isLocked());
		System.out.println("Held by this thread: "+lock.isHeldByCurrentThread());
		boolean locked = lock.tryLock();
		System.out.println("Lock acquired: "+locked);
		try {
		System.out.println(Thread.currentThread().getName()+" Task "+number+ "Started");
		for(int i=number*100;i<=number*100+99;i++) {
			System.out.print(i+" ");
		}
		if((number%2)!=0) {
			Thread.sleep(2000);
		}
		System.out.println(Thread.currentThread().getName()+ "Task "+number+ "Done");
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("Unlocked: "+Thread.currentThread().getName());
		}
	}
}
