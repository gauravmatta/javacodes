/*
 * One of the shops in Hackermall is offering discount coupons based on a puzzling problem.
 * There are n tags where each tag has a value denoted by val[i]. 
 * A customer needs to choose the tags in such a way that the sum of values is even. 
 * Find the maximum possible even sum of values of tags that can be chosen.
 */
package com.javaimplant.codingProblems.ibm;

public class MaximumEvenSum {
	
	static long getMaximumEvenSum(int arr[]) {
		int pos_sum=0;
		for(int num : arr) {
			if(num>0) {
				pos_sum += num;
			}
		}
			if(pos_sum%2==0) {
				return pos_sum;
			}
			
			int ans=Integer.MIN_VALUE;
			for(int num : arr) {
				if(num%2!=0) {
					if(num>0) {
						ans=Math.max(ans, pos_sum-num);
					}else {
						ans=Math.max(ans, pos_sum+num);
					}
				}
			}
		return ans;
	}

	public static void main(String[] args) {
		int[] a = {-1,-2,-3,8,7};
		System.out.println(getMaximumEvenSum(a));

	}

}
