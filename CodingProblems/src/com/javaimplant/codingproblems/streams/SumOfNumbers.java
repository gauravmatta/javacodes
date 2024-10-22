package com.javaimplant.codingproblems.streams;

import java.util.Arrays;
import java.util.List;

public class SumOfNumbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,4,5,6,22,3,90,89,2,1,3,4,55,6);
		Integer sum = list.stream().reduce(0,(a,b)->a+b);
		System.out.println("Sum of Numbers :"+ sum);
	}
}
