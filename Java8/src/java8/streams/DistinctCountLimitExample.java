package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
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
	}

}
