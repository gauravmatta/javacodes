package com.javaimplant.forkjoinpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

public class ForkJoinPoolExample {

	private static final Logger LOGGER  = Logger.getLogger(ForkJoinPoolExample.class.getName());

	public static void main(String[] args) {
		LOGGER.info("Thread Name =>"+Thread.currentThread().getName());
		try {
		CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
			LOGGER.info("Is Thread Demon==>"+Thread.currentThread().isDaemon());
			LOGGER.info("Called Thread Name =>"+Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				throw new IllegalStateException();
			}
			System.out.println("Separate Thread than the main Thread.");
		});
		LOGGER.info("Common Pool Parallelsim==>"+ForkJoinPool.getCommonPoolParallelism());
		LOGGER.info("Common Pool Get Parallelsim==>"+ForkJoinPool.commonPool().getParallelism());
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
