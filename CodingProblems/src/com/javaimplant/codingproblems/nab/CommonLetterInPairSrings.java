/*
 * You are given an array S consisting of N strings. Every string is of the same length M. Your 
 * task is to find a pair of strings in array S, such that there exists a position in which both
 * of the strings have the same letter. Both the index in attay S and the positions in the
 * strings are numbered from zero.For example, given S = ["abc", "bca", "dbe"], string 0 ("abc")
 * and string 2 ("dbe") have the same letter 'b' in position 1. On the other hand, for strings 
 * "abc" and "bca" there does not exist a position in which they have the same letter. Write a 
 * function: class Solution { public int[] solution(String[] s); } that, given a zero-indexed 
 * array S of N strings, returns an array describing a pair of strings from S which share a 
 * common letter at some index. If there is no such pair, the function should return an empty 
 * array. If there is more than one correct answer, the function can return any of them. 
 * The result should be represented as an array containing three integers. The first two
 * integers are the indexes in S of the strings belonging to the pair. The third integer is the
 * position of the common letter. For S=[ "abc", "bca", "dbe"], as above, the result array should
 * be represented as [0,2,1]. Another correct answer is [2,0,1], as the order of indexes of
 * strings does not matter. Examples: 1. Given: S=[ "abc", "bca", "dbe"], your function may 
 * return [0,2,1] as described above. there is no such pair, the function should return an empty
 * array. If there is more than one correct answer, the function can return any of them. The
 * result should be represented as an array containing three integers. The first two integers are
 * the indexes in S of the strings belonging to the pair.The third integer is the position of the
 * common letter.
 */
package com.javaimplant.codingproblems.nab;

public class CommonLetterInPairSrings {
	public static int[] solution(String[] s) {
		   int n = s.length;
		   int m = s[0].length();

		   for (int i = 0; i < n; i++) {
		       for (int j = i + 1; j < n; j++) {
		           for (int k = 0; k < m; k++) {
		               if (s[i].charAt(k) == s[j].charAt(k)) {
		                   return new int[] {i, j, k};
		               }
		           }
		       }
		   }

		   return new int[0];
		}
	
	public static void main(String[] args) {
		System.out.println(solution(new String[]{"abc", "bca", "dbe"}));
	}
}
