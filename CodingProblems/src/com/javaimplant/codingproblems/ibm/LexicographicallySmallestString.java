/*
 * Two strings are given, word and substr. Some of the characters in word are a question mark (?).
 * ﻿Find the lexicographically smallest string that can be obtained by replacing '?' ﻿characters such
 * that substr appears at least once. If it is not possible to do so,﻿return "-1".
 * Note:
 * A substring is a coptiguous sequence of characters within a string. For example, "bcd" is a 
 * substring of "abcde" but "ac" is not.
 * For two strings a and 𝑏 ﻿of the same length, 𝑎 ﻿is lexicographically smaller than 𝑏 if ai<b𝑖 for some
 * 0<|𝑎|𝑎𝑗=𝑏𝑗 
 * word = 𝑎𝑠?𝑏?𝑒?𝑔𝑓 
 * substr = 𝑑𝑏𝑘.
 * Replace 3𝑟𝑑 and 5𝑡ℎ dbk 0≤𝑗.
 * Example word = 𝑎𝑠?𝑏?𝑒?𝑔𝑓 substr =𝑑𝑏𝑘.Replace the 3𝑟𝑑 and 5𝑡ℎ characters with '𝑑' ﻿and '𝑘' 𝑡𝑜 
 * get "asdbke?𝑔𝑓" ﻿which has substr ="𝑑𝑏𝑘" 𝑎𝑠 𝑎 substring. Replace the remaining '?' with '𝑎'.
 * The final string 𝑖𝑠 "asdbkeagf".The answer 𝑖𝑠 ﻿"asdbkeagf", without quotes.
 */
package com.javaimplant.codingproblems.ibm;

public class LexicographicallySmallestString {
	
	static String smallest_lexographical_string(String word,String substr) {
		int lenWord = word.length();
		int lenSubstr = substr.length();
		for(int i=0;i<=lenWord-lenSubstr;i++) {
			boolean matchFound = true;
			char[] tempWord = word.toCharArray();
			for(int j=0;j<lenSubstr;j++) {
				if(tempWord[i+j] !='?' && tempWord[i+j]!= substr.charAt(j)) {
					matchFound=false;
					break;
				}
				tempWord[i+j]=substr.charAt(j);
			}
			if(matchFound) {
				for(int k=0;k<lenWord;k++) {
					if(tempWord[k]=='?') {
						tempWord[k]='a';
					}
				}
				return new String(tempWord);
			}
		}
		return "-1";
	}
	
	public static void main(String[] args) {
		String word = "as?b?e?gf";
		String substr ="dbk";
		String result = smallest_lexographical_string(word,substr);
		System.out.println(result);
	}

}
