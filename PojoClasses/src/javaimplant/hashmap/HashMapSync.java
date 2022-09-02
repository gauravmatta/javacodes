package javaimplant.hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapSync {
	
	public static void main(String[] args) {
		Map<String,String> map1 = new HashMap<String, String>();
		map1.put("1","Java");
		map1.put("2","Implant");
		map1.put("3","Gaurav");
		
		//create synchronizedMap
		Map<String,String> syncMap =Collections.synchronizedMap(map1);
		System.out.println(syncMap);
		
		//concurrenthashMap
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put("A", "Java");
		concurrentHashMap.put("B", "Python");
		concurrentHashMap.put("C", "Ruby");
		
		System.out.println(concurrentHashMap.get("A"));
	}

}
