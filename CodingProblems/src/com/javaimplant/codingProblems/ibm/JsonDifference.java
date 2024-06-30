/*
 * implement a simple prototype service to find the difference between two json objects
 * To keep the prototype simple a Json will have only key value pairs with no nested elements.
 * Find the keys for whose values are different.
 * If a key is present in only one of the Json's it should not be considered in result. 
 * The list of keys should be sorted in lexicographically ascending order.
 */
package com.javaimplant.codingProblems.ibm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonDifference {
	
	public static Map<String,String> jsonParse(String jsonString) {
		Map<String,String> result = new HashMap<>();
		int pos=0;
		while(pos<jsonString.length()) {
			int keyStart = jsonString.indexOf('"',pos+1);
			int keyEnd = jsonString.indexOf('"',keyStart+1);
			int valueStart = jsonString.indexOf('"',keyEnd+1);
			int valueEnd = jsonString.indexOf('"',valueStart+1);
			if(keyStart != -1 && keyEnd != -1 && valueStart != -1 && valueEnd!= -1) {
				String key = jsonString.substring(keyStart+1,keyEnd);
				String value = jsonString.substring(valueStart+1,valueEnd);
				result.put(key, value);
				pos=valueEnd+1;
			} else {
				break;
			}
		}
		return result;
	}
	
	public static List<String> getssoNptif(String json1,String json2){
		List<String> diff = new ArrayList<>();
		Map<String,String> map1 = jsonParse(json1);
		Map<String,String> map2 = jsonParse(json2);
//		Map<String,String> keys = (map1.size()<map2.size()?map1:map2);
		Set<String> keys = (map1.size()<map2.size())?map1.keySet():map2.keySet();
		
		for(String key: keys) {
			if(map1.containsKey(key) && map2.containsKey(key)) {
				if(!map1.get(key).equals(map2.get(key))) {
					diff.add(key);
				}
			}
		}
		
//		for(Map.Entry<String,String> entry: keys.entrySet()) {
//			String key = entry.getKey();
//			if(map1.containsKey(key) && map2.containsKey(key)) {
//				if(!map1.get(key).equals(map2.get(key))) {
//					diff.add(key);
//				}
//			}
//		}
//		diff.sort(null);
		Collections.sort(diff);
		return diff;
	}

	public static void main(String[] args) {
		String json1 = "{\"hello\": \"world\",\"hi\":\"hello\",\"you\":\"me\"}";
		String json2 = "{\"hello\": \"world\",\"hi\":\"helloo\",\"you\":\"me\"}";
		List<String> result = getssoNptif(json1, json2);
		result.forEach(r -> System.out.println(r));
	}
}
