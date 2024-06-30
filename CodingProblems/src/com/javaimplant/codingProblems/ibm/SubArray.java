/*
 * Find subarrays with a given sum in an array
 * Given an integer array, find subarrays with a given sum in it.
 * For example,
 * Input: nums[] = { 3, 4, -7, 1, 3, 3, 1, -4 }
 * target = 7
 * Output:
 * { 3, 4 }
 * { 3, 4, -7, 1, 3, 3 }
 * { 1, 3, 3 }
 * { 3, 3, 1 }
 */
package com.javaimplant.codingProblems.ibm;

import java.util.ArrayList;
import java.util.List;

public class SubArray {
	
	static void print(List<Integer> nums, int i, int j) {
		for (int k = i; k <= j; k++) {
			System.out.print(nums.get(k)+" ");
		}
		System.out.println();
	}

	static void findSubArrays(List<Integer> nums,int target) {
		int n = nums.size();
		for(int i=0;i<n;i++) {
			int sum_so_far=0;
			for (int j = i; j < n; j++) {
				sum_so_far += nums.get(j);
				if (sum_so_far == target) {
					print(nums, i, j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
	List<Integer> nums = new ArrayList<Integer>() {{
		add(3);
		add(4);
		add(-7);
		add(1);
		add(3);
		add(3);
		add(1);
		add(-4);
	}};
	int target = 7;
	findSubArrays(nums,target);
	}

}
