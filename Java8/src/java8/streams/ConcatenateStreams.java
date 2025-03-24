package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatenateStreams {

	public static void main(String[] args) {
		List<String> animalsList = Arrays.asList("Dog","Cat","Elephant","Girraf","Monkey","Loin","Tiger","Leapord");
		List<String> birdsList = Arrays.asList("Peacock","Parrot","Crow","Sparrow","Cock","Hen","Duck","Swan","Pigeon");
		Stream<String> animalStream = animalsList.stream();
		Stream<String> birdsStream = birdsList.stream();
		Stream<String> animalsBirdsStream = Stream.concat(animalStream,birdsStream);
		List<String> finalList = animalsBirdsStream.toList();
		List<Integer> list1 = Arrays.asList(33,44,55);
		List<Integer> list2 = Arrays.asList(55,22,99,33);
		Map<Integer, Long> frequency = Stream.of(list1, list2).flatMap(List::stream).sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(frequency);
		System.out.println(finalList);
	}

}
