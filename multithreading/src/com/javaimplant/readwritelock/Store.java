package com.javaimplant.readwritelock;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Store {

	private List<Items> items = Arrays.asList(
			new Items("Chair",20),
			new Items("Table",15),
			new Items("Lamp",10)
			);
	
	private ExecutorService executorService = Executors.newFixedThreadPool(2);
	private Callback callback;
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	
	public Store(Callback callback) {
		this.callback=callback;
	}
	
	public void syncLatestPrice() {
		Lock writeLock= lock.writeLock();
		executorService.execute(()->{
			writeLock.lock();
			try {
				Thread.sleep(500);
				items.get(0).setValue(35);
				items.get(1).setValue(20);
				items.get(2).setValue(35);
				System.out.println("Price Hiked : "+ getTotal());
				callback.onInvoiceSync();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			writeLock.unlock();
		});
	}
	
	public void prepareInvoice() {
		Lock readLock = lock.readLock();
		executorService.execute(()->{
			readLock.lock();
			int total = getTotal();
			System.out.println("Your Invoice is for the amount : "+ total);
			callback.onInvoicePrepared(total);
			readLock.unlock();
		});
	}
	
	private int getTotal() {
		int total=0;
		for(Items item:items) {
			total+=item.getValue();
		}
		return total;
	}
	
	public interface Callback{
		void onInvoiceSync();
		void onInvoicePrepared(int total);
	}
}
