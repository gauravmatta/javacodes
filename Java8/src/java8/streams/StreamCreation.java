package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreation {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("arm","nose","toe","leg","lip","hand","eye","ear","head");
		Stream<String> myStream = list.stream();
		
		String[] array = {"apple","banana","cherry"};
	
		Stream<String> stream = Arrays.stream(array);
		
		
		
	}
	

}
