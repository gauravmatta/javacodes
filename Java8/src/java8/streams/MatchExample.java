package java8.streams;

import java.util.HashSet;
import java.util.Set;

public class MatchExample {
	
	public static void main(String[] args) {
		Set<String> fruits = new HashSet<>();
		fruits.add("One Apple");
		fruits.add("One Mango");
		fruits.add("Two Apples");
		fruits.add("More Grapes");
		fruits.add("Two Guavas");
		
		boolean anyMatch = fruits.stream().anyMatch(value -> {
			return value.startsWith("One");
		});
		System.out.println(anyMatch);
		
		boolean allMatch = fruits.stream().allMatch(value->{
			return value.startsWith("One");
		});
		System.out.println(allMatch);
		
		boolean noneMatch = fruits.stream().noneMatch(element ->{
			return element.startsWith("One");
		});
		System.out.println(noneMatch);
	}

}
