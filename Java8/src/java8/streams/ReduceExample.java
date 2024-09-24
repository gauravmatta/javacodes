package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
	public static void main(String[] args) {
		
		List<String> strList = Arrays.asList("A","B","C","1","2","3");
		Optional<String> reduce = strList.stream().reduce((value,combinevalue)->{
			return combinevalue+value;
		});
		System.out.println(reduce.get());
		List<String> stringList = Arrays.asList("A","B","C","1","2","3");
		Object arr[]=stringList.stream().toArray();
		System.out.println(arr.length);
		for (Object object : arr) {
			System.out.println(object);
		}
	}
}
