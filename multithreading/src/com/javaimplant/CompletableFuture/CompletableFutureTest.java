package com.javaimplant.CompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		
		CompletableFuture<String> thenApply = thenApply();
		try {
			System.out.println(thenApply.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		CompletableFuture<Void> thenAccept = thenAccept();
		try {
			System.out.println(thenAccept.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		CompletableFuture<Void> thenRun = thenRun();
		try {
			thenRun.get();
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		CompletableFuture<String> thenCompose = CompletableFuture.supplyAsync(()->" Then Compose Hello, ")
		.thenCompose(s->CompletableFuture.supplyAsync(()->s+" World!!!"));
		
		try {
			System.out.println(thenCompose.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		CompletableFuture<String> thenCombine = CompletableFuture.supplyAsync(()->"Then Combine Hello, ")
				.thenCombine(CompletableFuture.supplyAsync(()->" World!!!"),(s1,s2)->s1+s2);
		
		try {
			System.out.println(thenCombine.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		CompletableFuture<Void> thenAcceptBoth = CompletableFuture.supplyAsync(()->"Then Accept Both Hello, ")
		.thenAcceptBoth(CompletableFuture.supplyAsync(()->" World!!!"), (s1,s2)->System.out.println(s1+s2));
		
		try {
			System.out.println(thenAcceptBoth.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->"India");
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->"Is");
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(()->"Beautiful Country");
		
		CompletableFuture<Void> allOf = CompletableFuture.allOf(future1,future2,future3);
		System.out.println(future1.isDone());
		System.out.println(future2.isDone());
		System.out.println(future3.isDone());
		try {
			System.out.println(allOf.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		String collect = Stream.of(future1,future2,future3).map(CompletableFuture::join).collect(Collectors.joining(" "));
		System.out.println(collect);
		
		
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
	
	private static CompletableFuture<Void> thenRun(){
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Following are the results of Then Run ");
		return completableFuture.thenRun(()->System.out.println(" ThenRun My task 1 is completed by "+ Thread.currentThread().getName()));
	}
	
	private static CompletableFuture<Void> thenAccept(){
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Then Accept My task 1 is completed by ");
		return completableFuture.thenAccept(s->System.out.println(s + Thread.currentThread().getName()));
	}
	
	private static CompletableFuture<String> thenApply(){
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Then Apply My task 1 is completed by ");
		return completableFuture.thenApply(s->s + Thread.currentThread().getName());
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
