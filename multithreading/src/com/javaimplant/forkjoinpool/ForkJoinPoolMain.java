package com.javaimplant.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolMain {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		int[] nums = new int[100];
		for(int i=0;i<nums.length;i++) {
			nums[i]=i;
		}
		System.out.println("Original Array ::");
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
		}
		SquareTransform task = new SquareTransform(nums,0,nums.length);
		long startTime = System.currentTimeMillis();
		pool.invoke(task);
		long endTime = System.currentTimeMillis();
		System.out.println("Total Time Taken : "+(endTime-startTime)+"ms");
		System.out.println();
		System.out.println("Squared Array ::");
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}

}
