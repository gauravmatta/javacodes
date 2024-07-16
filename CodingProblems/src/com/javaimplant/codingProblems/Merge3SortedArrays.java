package com.javaimplant.codingProblems;

import java.util.*;

// Java program to merge three sorted arrays
// by merging two at a time.
class Merge3SortedArrays {

	static ArrayList<Integer> mergeTwo(List<Integer> A, List<Integer> B) {
		// Get sizes of vectors
		int m = A.size();
		int n = B.size();

		// ArrayList for storing Result
		ArrayList<Integer> D = new ArrayList<Integer>(m + n);

		int i = 0, j = 0;
		while (i < m && j < n) {

			if (A.get(i) <= B.get(j))
				D.add(A.get(i++));
			else
				D.add(B.get(j++));
		}

		// B has exhausted
		while (i < m)
			D.add(A.get(i++));

		// A has exhausted
		while (j < n)
			D.add(B.get(j++));

		return D;
	}

	// Driver code
	public static void main(String[] args) {
		Integer[] a = { 1, 2, 3, 5 };
		Integer[] b = { 6, 7, 8, 9 };
		Integer[] c = { 10, 11, 12 };
		List<Integer> A = Arrays.asList(a);
		List<Integer> B = Arrays.asList(b);
		List<Integer> C = Arrays.asList(c);

		// First Merge A and B
		ArrayList<Integer> T = mergeTwo(A, B);

		// Print Result after merging T with C
		ArrayList<Integer> ans = mergeTwo(T, C);
		for (int i = 0; i < ans.size(); i++)
			System.out.print(ans.get(i) + " ");
	}
}
