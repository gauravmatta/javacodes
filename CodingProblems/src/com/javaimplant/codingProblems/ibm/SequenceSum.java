/*
 * Given three integers, i, j, and k, a sequence sum to be the value of 
 * i+(i+1)+(i+2)+(i+3) ... j+(j - 1) +(j - 2)+(j - 3) ... k(increment from i until it equals j, 
 * then decrement from j until it equals k). given values i, j, and k, calculate the sequence sum as 
 * described.
 */
package com.javaimplant.codingProblems.ibm;

public class SequenceSum {
	
	static int seqSum(int i,int j,int k) {
		int sum =0;
		for(int l=i;l<=j;++l) {
			sum +=l;
		}
		for(int l=j-1;l>=k;--l) {
			sum +=l;
		}
		return sum;
	}
	
	public static void main(String args[]) {
		int result = seqSum(0,5,-1);
		System.out.println(result);
		result = seqSum(5,9,6);
		System.out.println(result);
	}
}
