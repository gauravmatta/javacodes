package com.javaimplant.readwritelock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class readwritemain {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		ReadWriteLock lock = new ReentrantReadWriteLock();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Runnable writeTask = () ->{
			lock.writeLock().lock();
			try {
				list.add("JavaImplant");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 finally {
				lock.writeLock().unlock();
			}
		};
		
		Runnable readTask = () ->{
			lock.readLock().lock();
			try {
				System.out.println(list.get(0));
				Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 finally {
				lock.readLock().unlock();
			}
		};
		executor.submit(writeTask);
		executor.submit(readTask);
		executor.submit(readTask);
	}
	
}
