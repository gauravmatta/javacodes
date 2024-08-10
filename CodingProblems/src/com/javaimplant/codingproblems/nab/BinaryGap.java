/*Given a positive integer n, find and return the longest distance between any two adjacent 1's 
 * in the binary representation of n. If there are no two adjacent 1's, return 0.Two 1's are 
 * adjacent if there are only 0's separating them (possibly no 0's). The distance between two 
 * 1's is the absolute difference between their bit positions. For example, the two 1's in 
 * "1001" have a distance of 3.*/
package com.javaimplant.codingproblems.nab;

public class BinaryGap {
	
	public static int solution(int n) {
		String bString = Integer.toBinaryString(n);
		boolean started =false;
		int counter =0;
		int maxCount=0;
		for(int i=0;i<bString.length();i++) {
			String c = bString.substring(i,i+1);
			if(c.equals("1")) {
				if(started && counter>maxCount) {
						maxCount=counter;
					}
				counter=0;
				started=true;
			}
			if(c.equals("0")) {
				counter++;
			}
		}
		return maxCount;
	}
	
	
public static void main(String[] args) {
	System.out.println(solution(22));
	System.out.println(solution(529));
	System.out.println(solution(32));
	System.out.println(solution(0));
	System.out.println(solution(1041));
}
}
