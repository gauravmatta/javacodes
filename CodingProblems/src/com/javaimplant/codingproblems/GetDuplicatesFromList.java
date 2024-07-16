package com.javaimplant.codingproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GetDuplicatesFromList {

	
	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();
		lst.add("a");
		lst.add("b");
		lst.add("c");
		lst.add("d");
		lst.add("e");
		lst.add("f");
		lst.add("g");
		lst.add("h");
		lst.add("h");
		lst.add("i");
		lst.add("j");
		lst.add("k");
		lst.add("l");
		lst.add("m");
		lst.add("n");
		lst.add("o");
		lst.add("a");
		lst.add("b");
		lst.add("c");
		lst.add("d");
		lst.add("e");
		lst.add("f");
		System.out.println(lst);
		Set<String> eset = new HashSet<String>();
		List<String> new_lst = lst.stream().filter(s-> !eset.add(s)).collect(Collectors.toList());
		System.out.println(new_lst);
	}
}
