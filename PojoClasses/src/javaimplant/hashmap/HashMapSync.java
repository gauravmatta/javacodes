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
		
		//Synchronized Hash Map
		Map<String, Integer> hashMap = new HashMap<>();
		Map<String, Integer> syncMap2 = Collections.synchronizedMap(hashMap);
		MapHelper mapHelper = new MapHelper(syncMap2);
		MapHelper2 mapHelper2 = new MapHelper2(syncMap2);
		MapHelper3 mapHelper3 = new MapHelper3(syncMap2);
		MapHelper4 mapHelper4 = new MapHelper4(syncMap2);
		
		for(Map.Entry<String,Integer> e: syncMap2.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}
		
		//Concurrent Hashmap
		ConcurrentHashMap<String, Integer> concurrentHashMap2 = new ConcurrentHashMap<>();
		MapHelper smapHelper = new MapHelper(concurrentHashMap2);
		MapHelper2 smapHelper2 = new MapHelper2(concurrentHashMap2);
		MapHelper3 smapHelper3 = new MapHelper3(concurrentHashMap2);
		MapHelper4 smapHelper4 = new MapHelper4(concurrentHashMap2);
		
		for(Map.Entry<String,Integer> e: concurrentHashMap2.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}
	}

}
