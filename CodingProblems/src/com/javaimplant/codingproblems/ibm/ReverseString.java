package com.javaimplant.codingproblems.ibm;

public class ReverseString {
	
	static String reverse(String str) {
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

	public static void main(String[] args) {
        StringBuilder str = new StringBuilder("JavaImplant");
        System.out.println("String = "+ str.toString());
        StringBuilder reverseStr = str.reverse();
        System.out.println("Reverse String = " + reverseStr.toString());
        System.out.println(reverse(str.toString()));
	}

}
