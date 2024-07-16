/*
 * Given two strings s1 and s2, let us assume that while typing the strings there were some backspaces 
 * encountered which are represented by #. The task is to determine whether the resultant strings after processing 
 * the backspace character would be equal or not.
 */
package com.javaimplant.codingproblems.ibm;

public class BackspaceCharacter {
	
	// function to remove backspaces and return refined string
	static String removeBackspace(String str) {
		StringBuilder res = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (c != '#') {
				res.append(c);
			} else if (res.length() > 0) {
				res.deleteCharAt(res.length() - 1);
			}
		}
		return res.toString();
	}
	
	// function to compare the two strings
	static boolean compare(String s, String t) {
		s = removeBackspace(s);
		t = removeBackspace(t);
		return s.equals(t);
	}
	
	// Driver code
	public static void main(String[] args) {
		String s = "ab#c";
		String t = "ad#c";
		if (compare(s, t)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}
