/*
 * Given a string with only characters X and Y. Find the minimum number of characters to remove 
 * from the string such that there is no interleaving of character X and Y and all the Xs appear 
 * before any Y.
 * 
 * Example 1:
 * Input:YXXXYXY
 * Output: 2
 * Explanation:
 * We can obtain XXXYY by:
 * Delete first Y -> XXXYXY
 * Delete last occurrence of X -> XXXYY
 * 
 * Example 2:
 * Input:YYXYXX
 * Output: 3
 * Explanation:We can remove all occurrences of X or Y.
 * 
 * Example 3:
 * Input:XXYYYY
 * Output: 0
 */
package com.javaimplant.codingproblems.nab;

public class NonInterLeavingCharacters {

	public static int minStep(String str) {
	       int charX = 'X';
	       int numY = 0;
	       int minDel = 0;

	       for (int i = 0; i < str.length(); i++) {
	           if (charX == str.charAt(i)) {
	               minDel = Math.min(numY, minDel + 1);
	           } else {
	               numY++;
	           }
	       }
	       return minDel;
	    }
	
	
	public static void main(String[] args) {
		System.out.println(minStep("YXXXYXY"));
		System.out.println(minStep("YYXYXX"));
		System.out.println(minStep("XXYYYY"));
	}

}
