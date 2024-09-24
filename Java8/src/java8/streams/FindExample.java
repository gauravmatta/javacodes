package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindExample {

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("one","two","three","one");
		Optional<String> any = stringList.stream().findAny();
		System.out.println(any.orElse(null));
		Optional<String> first = stringList.stream().findFirst();
		System.out.println(first.orElse(null));
	}
}
