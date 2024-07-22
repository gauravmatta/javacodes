package java8.streams;

import java.util.Arrays;
import java.util.List;

public class LazyEvaluation {
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(12,20,35,46,55,68,75);
//		System.out.println(values.stream()
//				.filter(i->i%5==0)
//				.reduce(0,(c,e)->c+e));
		
		
		System.out.println(values.stream()
				.filter(LazyEvaluation::isDivisible)
				.map(LazyEvaluation::mapDouble)
				.findFirst()
				.orElse(0));
	}
	
	public static boolean isDivisible(int i) {
		System.out.println("Checking Value :"+i);
		return i%5==0;
	}
	
	public static int mapDouble(int i) {
		System.out.println("Mapping value :"+i);
		return i*2;
	}
}
