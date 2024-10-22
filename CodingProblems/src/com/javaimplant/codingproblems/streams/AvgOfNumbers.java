package com.javaimplant.codingproblems.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AvgOfNumbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Double avg = list.stream().collect(Collectors.averagingInt(num->num));
		double avg1 = list.stream().mapToInt(num->num).average().getAsDouble();
		System.out.println(avg+" : "+avg1);		
	}
}
