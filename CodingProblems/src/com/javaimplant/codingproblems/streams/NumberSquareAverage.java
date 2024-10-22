package com.javaimplant.codingproblems.streams;

import java.util.Arrays;
import java.util.List;

public class NumberSquareAverage {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,10,20,30,15);
		double avg = list.stream().map(a -> a*a)
		.filter(e -> e>100)
		.mapToInt(e->e)
		.average().getAsDouble();
		System.out.println(avg);
	}

}
