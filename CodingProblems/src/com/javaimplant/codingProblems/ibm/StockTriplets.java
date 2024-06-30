/*
 * Given an array arr[] of size n and an integer X. 
 * Find if there’s a triplet in the array which divides the given integer X.
 */
		
package com.javaimplant.codingProblems.ibm;

public class StockTriplets {

    boolean find3Numbers(int A[], int arr_size, int sum)
    {
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {
 
            // Fix the second element as A[j]
            for (int j = i + 1; j < arr_size - 1; j++) {
 
                // Now look for the third number
                for (int k = j + 1; k < arr_size; k++) {
                    if ((A[i] + A[j] + A[k]) % sum == 0) {
                        System.out.println("Triplet is " + A[i] + ", " + A[j] + ", " + A[k]);
                    }
                }
            }
        }
        // If we reach here, then no triplet was found
        return false;
    }

	// Driver program to test above functions
	public static void main(String[] args)
	{
		StockTriplets triplet = new StockTriplets();
		int A[] = { 3,3,4,7,8 };
		int sum = 5;
		int arr_size = A.length;
		triplet.find3Numbers(A, arr_size, sum);
	}
	
	int partition(int A[], int si, int ei)
	{
		int x = A[ei];
		int i = (si - 1);
		int j;

		for (j = si; j <= ei - 1; j++) {
			if (A[j] <= x) {
				i++;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		int temp = A[i + 1];
		A[i + 1] = A[ei];
		A[ei] = temp;
		return (i + 1);
	}

	/* Implementation of Quick Sort
	A[] --> Array to be sorted
	si --> Starting index
	ei --> Ending index
	*/
	void quickSort(int A[], int si, int ei)
	{
		int pi;

		/* Partitioning index */
		if (si < ei) {
			pi = partition(A, si, ei);
			quickSort(A, si, pi - 1);
			quickSort(A, pi + 1, ei);
		}
	}
}