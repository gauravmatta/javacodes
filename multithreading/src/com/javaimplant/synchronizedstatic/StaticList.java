package com.javaimplant.synchronizedstatic;

import java.util.ArrayList;

public class StaticList {
	private static ArrayList<Integer> numberList = new ArrayList<>();
	static void addToList(Integer number) {
		numberList.add(number);
	}
	static void displayList() {
		System.out.println(numberList);
	}
}
