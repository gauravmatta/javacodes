/*
 *  For a given string split it in substring, whenever a char is 
 *  repeated and print the longest substring.
 *  Input: Str= “aslkjfddterr” Output: “aslkjfd” as second substring “ter” will be smaller in length.
 */

package com.javaimplant.codingproblems.ibm;

import java.util.HashSet;

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
	
	
	 public static void printLongestSubstring(String s)
	  {
	    int n = s.length();
	    int l = 0;
	    int r = 0;
	    HashSet<Character> visited = new HashSet<>();
	    int maxStr = 0;
	    int maxL = 0, maxR = 0;
	    while (r < n) {
	      if (!visited.contains(s.charAt(r))) {
	        visited.add(s.charAt(r));
	        if (r - l + 1 > maxStr) {
	          maxStr = r - l + 1;
	          maxL = l;
	          maxR = r;
	        }
	        r++;
	      }
	      else {
	        visited.remove(s.charAt(l));
	        l++;
	      }
	    }
	    for (int i = maxL; i <= maxR; i++) {
	      System.out.print(s.charAt(i));
	    }
	    System.out.println();
	  }

	public static void main(String[] args) {
		String longestSubString = longestSubString("aslkjfddterr");
		System.out.println(longestSubString);
		printLongestSubstring("aslkjfddterr");
	}

}
