package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinMaxCountExample {

	public static void main(String[] args) {
		List<Integer> numbersList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		long numberofEvenNumbers = numbersList.stream().filter(n->n%2==0).count();
		System.out.println(numberofEvenNumbers);
		
		Optional<Integer> min = numbersList.stream().min((val1,val2)->{
			return val1.compareTo(val2);
				});
		System.out.println(min.get());
		Optional<Integer> max = numbersList.stream().max((val1,val2)->{
			return val1.compareTo(val2);
				});
		System.out.println(max.get());
		
	}

}
