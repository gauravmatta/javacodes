package com.javaimplant.CompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureTest {
	public static void main(String[] args) {
		CompletableFuture<String> calaculateAsync = calaculateAsync();
		try {
			String result = calaculateAsync.get();
			System.out.println(result);
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Hello World");
		try {
			String result = completableFuture.get();
			System.out.println(result);
		} catch (ExecutionException|InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		CompletableFuture<Void> runAsync = runAsync();
		try {
			runAsync.get();
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		CompletableFuture<String> supplyAsync = supplyAsync();
		try {
			System.out.println(supplyAsync.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		
		CompletableFuture<String> cancelAsync = cancelAsync();
		try {
			String result = cancelAsync.get();
			System.out.println(result);
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}
	
	
	private static CompletableFuture<String> supplyAsync(){
		
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(()->"Supplier My task 1 is completed by "+ Thread.currentThread().getName());
		try {
			System.out.println(supplyAsync.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		return CompletableFuture.supplyAsync(()->"Supplier My task 2 is completed by "+ Thread.currentThread().getName(),Executors.newFixedThreadPool(2));
	}
	
	
	private static CompletableFuture<Void> runAsync(){
		
		CompletableFuture.runAsync(()->{
			System.out.println("Runnable My task 1 is completed by "+ Thread.currentThread().getName());
		});
		
		return CompletableFuture.runAsync(()->{
			System.out.println("Runnable My task 2 is completed by "+ Thread.currentThread().getName());
		},Executors.newFixedThreadPool(2));
	}

	private static CompletableFuture<String> calaculateAsync() {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		List<String> list = new ArrayList<>();
		list.add("PP");
		list.add("SS");
		list.add("BB");
		list.add("KK");
		Executors.newCachedThreadPool().submit(()->{
			try {
				Thread.sleep(20);
				String joinStr = String.join(",",list);
				System.out.println(Thread.currentThread().getName());
				completableFuture.complete(joinStr);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			return null;
		});		
		return completableFuture;
	}
	
	private static CompletableFuture<String> cancelAsync() {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		List<String> list = new ArrayList<>();
		list.add("PP");
		list.add("SS");
		list.add("BB");
		list.add("KK");
		Executors.newCachedThreadPool().submit(()->{
			try {
				Thread.sleep(20);
				String joinStr = String.join(",",list);
				System.out.println(Thread.currentThread().getName());
				completableFuture.cancel(true);
			} catch (InterruptedException | CancellationException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			return null;
		});
		
		return completableFuture;
	}
}
