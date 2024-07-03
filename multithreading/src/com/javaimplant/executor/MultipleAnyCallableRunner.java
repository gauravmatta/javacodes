package com.javaimplant.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.javaimplant.threads.CallableTask;

public class MultipleAnyCallableRunner {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		 List<CallableTask> tasks = Arrays.asList(new CallableTask("Spring Implant"),
				 new CallableTask("Java Implant"),new CallableTask("SE Implant"));
	
		try {
			String result = executorService.invokeAny(tasks);
			System.out.println(result);
		
		} catch (InterruptedException|ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		executorService.shutdown();
	}

}
