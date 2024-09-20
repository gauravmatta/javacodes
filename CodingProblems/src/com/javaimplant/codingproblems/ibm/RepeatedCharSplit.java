/*
 *  For a given string split it in substring, whenever a char is 
 *  repeated and print the longest substring.
 *  Input: Str= “aslkjfddterr” Output: “aslkjfd” as second substring “ter” will be smaller in length.
 */

package com.javaimplant.codingproblems.ibm;

public class RepeatedCharSplit {
	
	public static String longestSubString(String str) {
		String result = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            sb.append(currentChar);
            if (i < str.length() - 1 && currentChar == str.charAt(i + 1) && sb.length()>result.length()) {
            		result = sb.toString();
            		sb = new StringBuilder();
            	}   
		}	
		return result;
	}

	public static void main(String[] args) {
		String longestSubString = longestSubString("aslkjfddterr");
		System.out.println(longestSubString);
	}

}
