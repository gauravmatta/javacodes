/*Find out vowels from given string, sort the sequence of vowels in the string and replace with vowels position.
 * For ex.
 * Input string -
 * vowelssortprogram
 * o    e      o       o    a    ( Original seq of vowels )
 * a    e      o       o    o    ( Sorted seq of vowels )
 * So final output will be after sorted seq vowels – vawelssortprogom
 * Use Java 8 feature or Core Java , ensure you solve this with optimize way. This is important
 */

package com.javaimplant.codingproblems.ibm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowel {
	    
	public static String sortVowels(String s) {	       
	        List<Character> vowels = new ArrayList<>();
	        char[] chars = s.toCharArray();      
	        for (char c : chars) {
	            char lowerCase = Character.toLowerCase(c);
	            if (lowerCase == 'a' || lowerCase == 'e' || lowerCase == 'i' || lowerCase == 'o' || lowerCase == 'u') {
	                vowels.add(c);
	            }
	        }
	        Collections.sort(vowels);
	        int vowelIndex = 0;
	        for (int i = 0; i < chars.length; ++i) {
	            char lowerCase = Character.toLowerCase(chars[i]);
	            if (lowerCase == 'a' || lowerCase == 'e' || lowerCase == 'i' || lowerCase == 'o' || lowerCase == 'u') {
	                chars[i] = vowels.get(vowelIndex++);
	            }
	        }
	        return String.valueOf(chars);
	    }
	    
	public static void main(String[] args) {
		String sortVowels = sortVowels("vowelssortprogram");
		System.out.println(sortVowels);
	}
}
