/* Take this string – “String numinput = "8555166699"
 * Find out bigger no from consecutive Nos from given string
 * So in above examples – there are three set of consecutive nos – 555, 666 and 99 , so bigger no is 666 and that should be the output
 * Please solve using Java 8 features only without loop
 */

package com.javaimplant.codingproblems.ibm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class BiggestConsequtiveSameNumber {

	public static String findBiggestSameDigitString(String num) {
		if (num == null || num.isEmpty()) {
			return "";
		}
		char digit = findMostFrequentDigit(num);
		return buildSameDigitString(digit, countDigitOccurrences(num, digit));
	}

	private static char findMostFrequentDigit(String num) {
		int[] digitCounts = new int[10];
		for (char c : num.toCharArray()) {
			digitCounts[c - '0']++;
		}
		
		int maxCount = 0;
		char maxDigit = '0';
		for (int i = 9; i >= 0; i--) {
			if (digitCounts[i] > maxCount) {
				maxCount = digitCounts[i];
				maxDigit = (char) (i + '0');
			}
		}
		return maxDigit;
	}

	private static int countDigitOccurrences(String num, char digit) {
		int count = 0;
		for (char c : num.toCharArray()) {
			if (c == digit) {
				count++;
			}
		}
		return count;
	}

	private static String buildSameDigitString(char digit, int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(digit);
		}
		return sb.toString();
	}
	
	public static String largestConsecutiveIntegerUsingStream(String num) {
		List<Character> charList = num.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Long maxCount = charList.stream()
		.collect(Collectors.groupingBy(c->c,Collectors.counting()))
		.entrySet()
		.stream()
		.max(Map.Entry.comparingByValue())
		.map(Entry::getValue)
		.orElse(null);
		
		Character name = charList.stream()
		.collect(Collectors.groupingBy(c->c,Collectors.counting()))
		.entrySet()
		.stream()
		.filter(e -> Objects.equals(e.getValue(), maxCount))
        .max(Map.Entry.comparingByKey())
        .map(Entry::getKey)
		.orElse(null);
		return String.valueOf(name).repeat(maxCount.intValue());
	}
	
	static int count7(Long n) {
	    if(n == 0) return 0;
	    return (n%10 == 6 ? 1 : 0) + count7(n/10);
	}

	public static String largestConsecutiveInteger(String num) {
		List<Character> charList = num.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Stack<Character> charStack = new Stack<>();
		charStack.addAll(charList);
		System.out.println(charStack);
		StringBuilder str = new StringBuilder();
		Character previous = null;
		List<String> strList = new ArrayList<>();
		while (!charStack.empty()) {
			if (previous == null) {
				previous = charStack.pop();
				str.append(previous);
			} else {
				Character next = charStack.pop();
				if (Objects.equals(previous, next)) {
					str.append(next);
					if (charStack.empty())
						strList.add(str.toString());
				} else {
					strList.add(str.toString());
					str.delete(0, str.length());
					previous = next;
					str.append(next);
					if (charStack.empty())
						strList.add(str.toString());
				}
			}
		}
		Collections.sort(strList, (s1, s2) -> Integer.parseInt(s2) - Integer.parseInt(s1));
		return strList.get(0);
	}
	
	public static String largestConsecutiveIntegerDeque(String num) {
		List<Character> charList = num.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Deque<Character> charQueue = new LinkedList<>();
		charQueue.addAll(charList);
		System.out.println(charQueue);
		StringBuilder str = new StringBuilder();
		Character previous = null;
		List<String> strList = new ArrayList<>();
		while (!charQueue.isEmpty()) {
			if (previous == null) {
				previous = charQueue.pop();
				str.append(previous);
			} else {
				Character next = charQueue.pop();
				if (Objects.equals(previous, next)) {
					str.append(next);
					if (charQueue.isEmpty() && str.length()>1)
						strList.add(str.toString());
				} else {
					if(str.length()>1) {
					strList.add(str.toString());
					}
					str.delete(0, str.length());
					previous = next;
					str.append(next);
				}
			}
		}
		System.out.println(strList);
		Collections.sort(strList, (s1, s2) -> Integer.parseInt(s2) - Integer.parseInt(s1));
		return strList.get(0);
	}

	public static void main(String[] args) {
		String largestGoodInteger = largestConsecutiveIntegerDeque("85551666992");
		System.out.println(largestGoodInteger);
		largestGoodInteger = largestConsecutiveInteger("8555166699");
		System.out.println(largestGoodInteger);
		System.out.println(findBiggestSameDigitString("122233333"));
		System.out.println(findBiggestSameDigitString("8555166699"));
		System.out.println(largestConsecutiveIntegerUsingStream("8555166699"));
	}

}
