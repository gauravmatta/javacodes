package com.javaimplant.codingProblems.ibm;

public class ReverseString {

	public static void main(String[] args) {
        StringBuilder str = new StringBuilder("JavaImplant");
        System.out.println("String = "+ str.toString());
        StringBuilder reverseStr = str.reverse();
        System.out.println("Reverse String = " + reverseStr.toString());
	}

}
