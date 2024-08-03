package com.javaimplant.codingproblems;

public class RemoveTrailingLeadingSpacesFromString {

	public static void main(String[] args) {
		String name = "     Gaurav Matta    ";
		int i = name.length() - 1;
		while (i >= 0 && Character.isWhitespace(name.charAt(i))) {
			i--;
		}
		String removedTrail = name.substring(0, i + 1);
		i = 0;
		while (i <= removedTrail.length() - 1 && Character.isWhitespace(removedTrail.charAt(i))) {
			i++;
		}
		String trimString = name.substring(i, removedTrail.length());
		System.out.println(name);
		System.out.println(removedTrail);
		System.out.println(trimString);
	}
}