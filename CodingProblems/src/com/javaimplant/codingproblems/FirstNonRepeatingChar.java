/*
 * Using Streams Find first non repeating character
 */
		
package com.javaimplant.codingproblems;

import java.util.Arrays;

public class FirstNonRepeatingChar {
	
	public static int firstUniqChar(String s)
    {
		int[] freq = new int[26];
        Arrays.fill(freq, -1);
		s.chars().forEach(c->freq[c - 'a']++);
		
		 for (int i = 0; i < s.length(); ++i) {
	            if (freq[s.charAt(i) - 'a'] == 1) {
	                return i;
	            }
	        }

	        return -1;
		
		}

	public static void main(String[] args) {
		String s = "abcabcdef";
		System.out.println(firstUniqChar(s));
	}
}
