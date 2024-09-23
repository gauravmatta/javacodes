/* Take this string – “String numinput = "8555166699"
 * Find out bigger no from consecutive Nos from given string
 * So in above examples – there are three set of consecutive nos – 555, 666 and 99 , so bigger no is 666 and that should be the output
 * Please solve using Java 8 features only without loop
 */

package com.javaimplant.codingproblems.ibm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class BiggestConsequtiveSameNumber {
	
	 public static String largestGoodInteger(String num) {
		 List<Character> charList = num.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		 Stack<Character> charStack = new Stack<>();
		 charStack.addAll(charList);
		 System.out.println(charStack);
		 StringBuilder str = new StringBuilder();
		 Character previous = null;
		 List<String> strList = new ArrayList<>();
		 while(!charStack.empty()) {
			 if(previous==null) {
				 previous =charStack.pop();
				 str.append(previous);
			 } else {
				 Character next = charStack.pop();
				 if(Objects.equals(previous, next)) {
					 str.append(next);
					 if(charStack.empty())
						 strList.add(str.toString());
				 } else {
					 strList.add(str.toString());
					 str.delete(0, str.length());
					 previous=next;
					 str.append(next);
					 if(charStack.empty())
						 strList.add(str.toString());
				 }
			 }
		 }
		 Collections.sort(strList,(s1,s2) -> Integer.parseInt(s2) - Integer.parseInt(s1));
		 return strList.get(0);
	 }

	public static void main(String[] args) {
		String largestGoodInteger = largestGoodInteger("8555166699");
		System.out.println(largestGoodInteger);
	}

}
