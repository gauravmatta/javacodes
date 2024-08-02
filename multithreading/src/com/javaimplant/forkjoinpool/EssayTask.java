package com.javaimplant.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class EssayTask extends RecursiveTask<Long> {
	private static final long serialVersionUID = -4578248768553162407L;
	private static final int THRESHOLD =10;
	private int[] tasks;
	private int start;
	private int end;
	
	Logger logger = Logger.getLogger(EssayTask.class.getName());
	
	public EssayTask(int[] tasks, int start, int end) {
		super();
		this.tasks = tasks;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long finishedSubTopics=0;
		if(end-start<THRESHOLD) {
			for(int i=start;i<end;i++) {
				processing();
				finishedSubTopics++;
				System.out.println("Subsection:"+(i+1)+" Completed by:"+ Thread.currentThread().getName());
			}
			return finishedSubTopics;
		} else {
			int mid=(start+end)>>>1;
		EssayTask leftTask = new EssayTask(tasks, start, mid);
		EssayTask rightTask = new EssayTask(tasks, mid, end);
		leftTask.fork();
		rightTask.fork();
		return leftTask.join()+rightTask.join();
		}
	}
	private void processing() {
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(100,500));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.info(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		int[] tasks = new int[100];
		ForkJoinPool executor = ForkJoinPool.commonPool();
		EssayTask submitTasks = new EssayTask(tasks,0,tasks.length);
		System.out.println(executor.invoke(submitTasks));
		ForkJoinPool executor1 =new ForkJoinPool(5);
		System.out.println(executor1.invoke(submitTasks));
	}
}
