/*
 * An English lecture at Hacker Elementary School is aimed at teaching ALL students the letters of the alphabet.
 * The students are provided with a string word that consists of lowercase English letters. In one move, they can choose any index and let the character at that index be c. Then, the first occurrence of c to the left of and the first occurrence of c to the right of / are deleted (Note: the operation can still be carried out even if either the left or right occurrence doesn't exist).
 * For example, if word = "adabacaea", and if index 4 is chosen (0-based), the first occurrence of 'a' to the left and right of index 4 (bold, indices 2 and 6) are deleted leaving word - "adbacea".
 * Find the minimum number of moves the students need to perform in order to get a word of minimal length.
 * Example
 * Consider word - "baabacaa":
 * The following moves are optimal: 1. Choose index 0, b, c, then word = baaacaa. Delete the b to its 
 * right at index 3. There is no b to its left so the operation is finished.
 * 2.Now, choose index 2, a, then word is bacaa. 
 * 3. Now, choose index 3, a, then word is bca.
 * The word cannot be reduced further. The answer is 3.
 */
package com.javaimplant.codingproblems.ibm;

import java.util.HashMap;
import java.util.Map;

public class WordMinimumMoves {

	static int findMinimumMoves(String word) {
		System.out.println(word);
		int moves = 0;
		Map<Character,Integer> cmp = new HashMap<>();
		
		for(int i=0;i<word.length();i++) {
			if(cmp.containsKey(word.charAt(i))) {
				cmp.put(word.charAt(i), cmp.get(word.charAt(i))+1);
			} else {
				cmp.put(word.charAt(i), 1);
			}
		}
		
		for (Map.Entry<Character,Integer> mapElement : cmp.entrySet()) {
			System.out.println(mapElement.getKey()+"=>"+mapElement.getValue());
			if(mapElement.getValue()>1) {
				moves += mapElement.getValue()/2;
			}
		}
		return moves;
	}
	
	public static void main(String args[]) {
		String word = "baabacaa";
		int result = findMinimumMoves(word);
		System.out.println(result);
	}
	
}
