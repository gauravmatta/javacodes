/*
 * Write a program to calculate the factorial of the given number without using multiplication 
 * or division operator
 */
package com.javaimplant.codingProblems.ibm;

public class FactorialWithoutMultiplication {
	
	static int findFactorial(int n){
		int ans = n;
		for(int i=n-1;i>0;i--){
		int sum = 0;
		for(int j=0;j<i;j++){
		sum = sum + ans;
		}
		ans = sum;
		}
		return ans;
	}

	public static void main(String[] args) {
		int ans = findFactorial(5);
		System.out.println(ans);
	}

}
