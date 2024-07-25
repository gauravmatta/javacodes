package com.javaimplant.codingproblems.naggaro;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortMapOnValuesAndKeys {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
        map.put("apple", 2);
        map.put("banana", 1);
        map.put("orange", 2);

        // Sort by value, then by key
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue()
                    .thenComparing(Map.Entry.comparingByKey()))
            .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println(sortedMap);
	}
}
