package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ConcatenateStreams {

	public static void main(String[] args) {
		List<String> animalsList = Arrays.asList("Dog","Cat","Elephant","Girraf","Monkey","Loin","Tiger","Leapord");
		List<String> birdsList = Arrays.asList("Peacock","Parrot","Crow","Sparrow","Cock","Hen","Duck","Swan","Pigeon");
		Stream<String> animalStream = animalsList.stream();
		Stream<String> birdsStream = birdsList.stream();
		Stream<String> animalsBirdsStream = Stream.concat(animalStream,birdsStream);
		List<String> finalList = animalsBirdsStream.toList();
		System.out.println(finalList);
	}

}
