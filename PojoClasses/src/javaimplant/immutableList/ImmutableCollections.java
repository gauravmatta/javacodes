package javaimplant.immutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableCollections {

	public static void main(String[] args) {
	/*****Immutable List***/
		List<String> fruits = new ArrayList<>();
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Orange");
		
		//Before Java9 
		fruits = Collections.unmodifiableList(fruits);
//		fruits.add("Strawberry");
		
		//After Java 9
		List<String> fruit = List.of("Banana","Apple","Mango","Orange");
//		fruit.add("Strawberry");
		/*****Immutable List***/
		
		/*****Immutable Set***/
		Set<String> fruitset = new HashSet<>();
		fruitset.add("Banana");
		fruitset.add("Apple");
		fruitset.add("Banana");
		fruitset.add("Orange");
		
		//Before Java9
		Collections.unmodifiableSet(fruitset);
//		fruitset.add("Strawberry");
		
		//After Java9
		Set<String> fruitset9 = Set.of("Banana","Apple","Mango","Orange");
//		fruitset9.add("Strawerry");
		/*****Immutable Set***/
		
		/*****Immutable Map***/
		Map<Integer,String> fruitMap = new HashMap<>();
		fruitMap.put(1,"Banana");
		fruitMap.put(2,"Apple");
		fruitMap.put(3,"Papaya");
		fruitMap.put(4,"Orange");
		
		//Before Java9
		Collections.unmodifiableMap(fruitMap);
//		fruitMap.put(5,"Strawberry");
		//After Java9
		Map<Integer,String> map = Map.ofEntries(
				Map.entry(1,"Banana"),
				Map.entry(2,"Apple"),
				Map.entry(3,"Papaya"),
				Map.entry(4,"Orange"));
//		map.put(5, "Watermelon");
		/*****Immutable Map***/
		
		
		

	}

}
