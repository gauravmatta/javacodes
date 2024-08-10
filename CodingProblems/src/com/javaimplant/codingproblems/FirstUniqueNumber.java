package com.javaimplant.codingproblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FirstUniqueNumber {

	public static void main(String[] args) {
		   int[] arr = { 9, 4, 9, 6, 7, 4 };
	       System.out.println(firstNonRepeating(arr));
	}

	private static Integer firstNonRepeating(int[] arr) {
		List<Integer> list =Arrays.stream(arr).boxed().toList();
		return list.stream().filter(a->(Collections.frequency(list,a)==1)).findFirst().orElse(null);
	}

}
