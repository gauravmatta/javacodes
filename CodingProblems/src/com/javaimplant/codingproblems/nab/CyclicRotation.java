package com.javaimplant.codingproblems.nab;

public class CyclicRotation {

	public static int[] solution(int[] a, int k) {
		if(a.length==0 || a.length==k) {
			return a;
		}
		for(int i=0;i<k;i++) {
		int lastValue = a[a.length-1];
		for(int j=a.length-2;j>=0;j--) {
			a[j+1]=a[j];
		}
		a[0]=lastValue;
		}
		return a;
	}
	
	
	public static void main(String[] args) {
		int[] solution = solution(new int[] {3,8,9,7,6},3 );
		for(int i:solution) {
			System.out.print(i+" ");
		}
		System.out.println();
		solution = solution(new int[] {0,0,0},1);
		for(int i:solution) {
			System.out.print(i+" ");
		}
	}

}
