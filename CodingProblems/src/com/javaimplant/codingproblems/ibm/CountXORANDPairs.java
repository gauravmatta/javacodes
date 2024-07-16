/*
 * For an array arr of n positive integers, count the unordered pairs (i,j)(0<=i<j<n)\
 * ﻿where arr[i] XOR arr[j]>arr[i] ﻿AND arr[j].
 * ﻿XOR denotes the bitwise XOR operation and AND denotes the bitwise AND operation. 
 * n=4, arr=[4,3,5,2]
 * All unordred pairs are
 * Indices	XOR	AND	XOR>AND
 * (0,1)	7	0	True
 * (0,2)	1	4	False
 * (0,3)	6	0	True
 * (1,2)	6	1	True
 * (1,3)	1	2	False
 * (2,3)	7	0	True
 * Answer is 4
 */
package com.javaimplant.codingproblems.ibm;

import java.util.ArrayList;
import java.util.List;

public class CountXORANDPairs {

	private static int dominatingXorPairs(List<Integer> arr) {
		int N = arr.size();
		int ans=0;
		int bits[] = new int[32];
		
		for(int i=0;i<N;i++) {
			int val = (int)(Math.log(arr.get(i))/Math.log(2));
			ans += bits[val];
			bits[val]++;
		}
		return N*(N-1)/2-ans;
	}
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>() {{
			add(4);
			add(3);
			add(5);
			add(2);
		}};
		int result = dominatingXorPairs(arr);
		System.out.println(result);
		

	}
}
