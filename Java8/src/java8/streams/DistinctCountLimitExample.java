package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctCountLimitExample {
	
	public static void main(String[] args) {
		List<String> vehiclesList = Arrays.asList("bus","car","bicycle","car","car","bike");
		List<String> distinctVehicles = vehiclesList.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctVehicles);
		vehiclesList.stream().distinct().forEach(System.out::println);
		
		long count = vehiclesList.stream().distinct().count();
		System.out.println(count);
		
		List<String> limitedVehiclesList = vehiclesList.stream().limit(3).collect(Collectors.toList());
		System.out.println(limitedVehiclesList);
		
		List<Integer> numbersList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		long numberofEvenNumbers = numbersList.stream().filter(n->n%2==0).count();
		System.out.println(numberofEvenNumbers);
	}

}
