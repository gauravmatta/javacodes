package com.javaimplant.codingproblems.nab;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class OddOccurrencesInArray {

	private static HashSet<Integer> aHash = new HashSet<>();	
	
	
	public static int solution (int[] a) {
		
		for(int i=0;i<a.length;i++) {
			int a1=a[i];
			if(aHash.contains(a1)) {
				aHash.remove(Integer.valueOf(a1));
			} else {
				aHash.add(a1);
			}
		}
		return aHash.iterator().next();
	}
	
	public static int solution2 (int[] a) {
		List<Integer> aList = Arrays.stream(a).boxed().toList();
		for(int i=0;i<a.length;i++) {
			int freq=Collections.frequency(aList, a[i]);
			if(freq%2!=0) {
				return a[i];
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[]{9,3,9,3,9,7,9}));
		System.out.println(solution2(new int[]{9,3,9,3,9,7,9}));
	}

}
