/*
Problem Statement:
Given a grid of size m*n, let us assume you are starting at (1, 1) and
your goal is to reach (m, n). At any instance, if you are on (x, y), you
can either go to (x, y + 1) or (x + 1, y).
Now consider if some obstacles are added to the grids. How many unique
paths would there be? An obstacle and space are marked as 1 and 0
respectively in the grid.
sample test case
n = 3, m = 3
arr = [
[0 0 0],
[0 1 0],
[0 0 0]
]
output:
2
*/
package com.javaimplant.codingProblems.ibm;

import java.util.ArrayList;
import java.util.List;

public class GridUniquePath {

	static int findUniquePath(List<List<Integer>> arr,int n,int m, int i, int j) {
		if (i == n - 1 && j == m - 1) {
		return 1;
		}
		if (i >= n || j >= m || arr.get(i).get(j) == 1) {
		return 0;
		}
		return findUniquePath(arr, n, m, i + 1, j) + findUniquePath(arr, n,m, i, j + 1);
	}

	public static void main(String[] args) {
		int n=3, m=3;
		List<List<Integer>> arr = new ArrayList<>();
		arr.add(new ArrayList<>() {{
			add(0);
			add(0);
			add(0);
		}});
		arr.add(new ArrayList<>() {{
			add(0);
			add(1);
			add(0);
		}});
		arr.add(new ArrayList<>() {{
			add(0);
			add(0);
			add(0);
		}});
		int i = 0;
		int j = 0;
		int result = findUniquePath(arr, n, m, i, j);
		System.out.println(result);
	}

}
