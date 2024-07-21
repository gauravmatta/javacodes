package com.javaimplant.readwritelock;

import java.util.concurrent.atomic.AtomicBoolean;

public class ItemStoreCaller {

	public static void main(String[] args) {
		AtomicBoolean syncing = new AtomicBoolean(true);
		AtomicBoolean processing = new AtomicBoolean(true);
		Store store = new Store(new Store.Callback() {
			
			@Override
			public void onInvoiceSync() {
				syncing.set(false);
			}
			
			@Override
			public void onInvoicePrepared(int total) {
				processing.set(false);				
			}
		});
		
		store.syncLatestPrice();
		store.prepareInvoice();
		while(syncing.get() || processing.get()) {
			
		}
		System.out.println("Program Terminted");
	}

}
