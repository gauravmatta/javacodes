/*
 * Fizz Buzz Problem states that given an integer n, for every integer i <= n, 
 * the task is to print “FizzBuzz” if i is divisible by 3 and 5, 
 * “Fizz” if i is divisible by 3, “Buzz” if i is divisible by 5 or i (as a string) 
 * if none of the conditions are true.
 */
package com.javaimplant.codingProblems;

import java.util.ArrayList; 
import java.util.List; 

public class FizzBuzz { 
	public static List<String> fizzBuzz(int n) 
	{ 
		// Declare a list of strings to store the results 
		List<String> result = new ArrayList<>(); 

		// Loop from 1 to n (inclusive) 
		for (int i = 1; i <= n; ++i) { 
			
			// Check if i is divisible by both 3 and 5 
			if (i % 3 == 0 && i % 5 == 0) {
				
				// Add "FizzBuzz" to the result list 
				result.add("FizzBuzz"); 
			} 
			
			// Check if i is divisible by 3 
			else if (i % 3 == 0) { 
				
				// Add "Fizz" to the result list 
				result.add("Fizz"); 
			} 
			
			// Check if i is divisible by 5 
			else if (i % 5 == 0) { 
				
				// Add "Buzz" to the result list 
				result.add("Buzz"); 
			} 
			else { 
				
				// Add the current number as a string to the 
				// result list 
				result.add(Integer.toString(i)); 
			} 
		} 

		// Return the result list 
		return result; 
	} 

	public static void main(String[] args) 
	{ 
		int n = 20; 

		// Call the fizzBuzz function to get the result 
		List<String> result = fizzBuzz(n); 

		// Print the result 
		for (String s : result) { 
			System.out.println(s + " "); 
		}
	} 
}