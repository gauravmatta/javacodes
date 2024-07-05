/*
 * Given an array arr of n integers, a sequence of n-1 operations must be performed on the array.
 * In each operation,Remove the minimum and maximum elements from the current array and add their sum 
 * back to the array.The cost of an operation, 
 * cost = ceil((minimum_element + maximum_element)/ (maximum_element-minimum_element+1)
 * Find the total cost to reduce the array to a single element.
 * Example: Given arr=[2,3,4,5,7] The possible sequence of operations are:
 * 1. Choose 2 and 7, the cost = ceil(2+7/7-2+1) = ceil(9/6). Remove 2 and 7, append 9. arr=[3,4,5,9]. Total cost = 2
 * 2. Choose 3 and 9, the cost = ceil(3+9/9-3+1) = ceil(12/7). Remove 3 and 9. Total cost = 3
 */
package com.javaimplant.codingproblems.ibm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayReductionCost {
	
	static int findTotalCost(List<Integer> arr) {
		int total_cost =0;
		while(arr.size()>1) {
			int minElement = Collections.min(arr);
			int maxElement = Collections.max(arr);
			int cost = (int) Math.ceil((double)(minElement+maxElement)/(maxElement-minElement+1));
			int minIndex = arr.indexOf(minElement);
			int maxIndex = arr.indexOf(maxElement);
			arr.remove(maxIndex);
			arr.remove(minIndex);
			arr.add(minElement+maxElement);
			total_cost+=cost;
		}
		return total_cost;
	}
	

	public static void main(String args[]) {
		List<Integer> arr1 = new ArrayList<>() {{
			add(2);
			add(3);
			add(4);
			add(5);
			add(7);
		}};
		
		int result = findTotalCost(arr1);
		System.out.println(result);
		
		List<Integer> arr2 = new ArrayList<>() {{
			add(3);
			add(5);
			add(2);
			add(1);
			add(9);
			add(6);
		}};
		
		result = findTotalCost(arr2);
		System.out.println(result);
		
		List<Integer> arr3 = new ArrayList<>() {{
			add(8);
			add(8);
			add(8);
			add(8);
		}};
		result = findTotalCost(arr3);
		System.out.println(result);
		
	}
}
