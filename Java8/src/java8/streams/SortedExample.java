package java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {

	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(2,4,1,3,7,5,9);
		List<Integer> sortedList = list1.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		List<Integer> reverserSorted = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverserSorted);
		
		List<String> listRoom = Arrays.asList("Table","Chair","Stool","WheelChair","DiningTable","Bed","Pillow","Bolster");
		List<String> sortedRoomList = listRoom.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedRoomList);
		List<String> reverseSortedRoomList = listRoom.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseSortedRoomList);

	}

}
