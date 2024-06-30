/*
 * Odd-Even-Transform Problem works on an array of integers (both positive, negative and zero)
 * ,﻿by taking in a value (a whole number)
 * that specifies the number of times the transformation has to be applied.On an array of integers, the transformation that needs to occur, n number of times:
 * Adds three (+3)﻿to each odd integer.
 * ﻿Subtracts three (-3)from each even integer
 * Example: [3,4,9],3 ﻿means, the array with integers 3,4,9 ﻿has to undergo transformation 3 times.[3,4,9]=>[6,1,12]=>[3,4,9]=>[6,1,12]
 * So the result is [6,1,12]
 */
package com.javaimplant.codingProblems.ibm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddEvenTransform {
	
	static List<Integer> numberTransform(List<Integer> arr,int n) {
	List<Integer> result =	arr.stream().map(a->{
			for(int i=0;i<n;i++) {
			if(a%2==0) {
				a=a-3;
			} 
			else
			{
				a=a+3;
			}
			System.out.println("Transformed Element=>"+a);
		}
		return a;	
		}).collect(Collectors.toList());
		return result;
	}
	
	public static void main(String args[]) {
		int n=3;
		List<Integer> arr = Arrays.asList(3,4,9);
		List<Integer> result = numberTransform(arr,n);
		result.forEach(a->System.out.println(a));
	}

}
