package com.javaimplant.codingProblems.naggaro;

public class ConvertVariable {

	public static String modify_variableName(String input1) {
//		String s = "thisIsAVariable"; //INPUT

		char ch[] = input1.toCharArray();

		// 1st approach
		String str = "";
		for (int i = 0; i < ch.length; i++) {
		if (Character.isUpperCase(ch[i])) {
		str += "_";
		str += ch[i];
		} else
		str += ch[i];
		}
		System.out.println(str.toLowerCase()); //O/P: this_is_a_variable
		return str.toLowerCase();
	}
	
	public static String modify_variableNameC2J(String input1) {

		char ch[] = input1.toCharArray();

		// 1st approach
		String str = "";
		for (int i = 0; i < ch.length; i++) {
		if (ch[i] == '_') {
		str += Character.toUpperCase(ch[++i]);
		} else
		str += ch[i];
		}
		System.out.println(str);
		return str;
	}
	
	public static void main(String args[]) {
		String s = modify_variableName("thisIsAVariable");
		String s2 = modify_variableNameC2J("this_is_a_variable");
		System.out.println("c++ variable ="+s);
		System.out.println("Java Variable ="+s2);
	}
}
