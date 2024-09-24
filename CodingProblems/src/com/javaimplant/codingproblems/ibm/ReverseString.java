/*Reverse the string
 * Ex.
 * String name = “rajesh”
 * Output – “hsejar”
 * Please don’t use loop , in built functions. Try to solve this optimize way and find out which data structure
 * is suitable to reversing order and apply that.
*/

package com.javaimplant.codingproblems.ibm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseString {
	
	static String reverseWithLoop(String str) {
		int i=0;
		int j=str.length()-1;
		char[] ch = str.toCharArray();
		while(i<=j) {
			ch[i] = (char)(ch[i] ^ ch[j]);
	        ch[j] = (char)(ch[i] ^ ch[j]);
	        ch[i] = (char)(ch[i] ^ ch[j]);
			i++;
			j--;
		}
		return String.valueOf(ch);
	}
	
	static String reverseWithoutLoop(String str) {
		List<Character> charList = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Stack<Character> charStack = new Stack<>();
		charStack.addAll(charList);
		StringBuilder builder = new StringBuilder();
		while(!charStack.empty()) {
			 builder.append(charStack.pop());
		 }
		return builder.toString();
	}
	
	static String reverseUsingStreams(String str) {
		List<String> charList = new ArrayList<>(Arrays.asList(str.split("")));
		Optional<String> reduce = charList.stream().reduce((value,combinevalue)->{
			return combinevalue+value;
		});
		return reduce.get();
	}

	public static void main(String[] args) {
        StringBuilder str = new StringBuilder("JavaImplant");
        System.out.println("String = "+ str.toString());
        StringBuilder reverseStr = str.reverse();
        System.out.println("Reverse String = " + reverseStr.toString());
        System.out.println(reverseWithLoop(str.toString()));
        StringBuilder str1 = new StringBuilder("JavaImplant");
        System.out.println(reverseWithoutLoop(str1.toString()));
        System.out.println(reverseUsingStreams(str1.toString()));
	}

}
