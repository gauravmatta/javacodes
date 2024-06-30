/*
 * Given a string s, return the maximum number of occurrences of any substring under the following rules:
 * The number of unique characters in the substring must be less than or equal to maxLetters.
 * The substring size must be between minSize and maxSize inclusive.
 */
package com.javaimplant.codingProblems.ibm;

import java.util.HashMap;

public class MaximumFrequencyString {
	
	static int getMaxOccurrences(String components, int minLength,int maxLength, int maxUnique) {
		int n = components.length();
		int maxOccurrences=0;
		
		for(int length=minLength;length<=maxLength;length++) {
			HashMap<Character, Integer> charCount = new HashMap<>();
			int uniqueChars = 0;
			for(int i=0;i<n;i++) {
				char currentChar = components.charAt(i);
				charCount.put(currentChar,charCount.getOrDefault(charCount, 0)+1);
				if(i>=length) {
					char leftChar=components.charAt(i-length);
					int count = charCount.get(leftChar);
					if(count==1) {
						charCount.remove(leftChar);
					} else {
						charCount.put(leftChar,count-1);
					}
				}
				if(charCount.size()<=maxUnique) {
					uniqueChars=charCount.size();
				}
				if(i>=length-1&&uniqueChars<=maxUnique) {
					String substring = components.substring(i-length+1,i+1);
					int count = countOccurences(components,substring,i-length+1);
					maxOccurrences=Math.max(maxOccurrences, count);
				}
			}
		}
		return maxOccurrences;
	}
	
	static int countOccurences(String components, String substring,int startIndex) {
		int count=0;
		for(int i=0;i<=startIndex;i++) {
			if(components.substring(i).startsWith(substring)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String components = "abcde";
		int minLength =2;
		int maxLength =3;
		int maxUnique = 3;
		System.out.println(getMaxOccurrences(components, minLength, maxLength, maxUnique));
		components = "abcde";
		minLength =2;
		maxLength =4;
		maxUnique = 26;
		System.out.println(getMaxOccurrences(components, minLength, maxLength, maxUnique));
	}

}
