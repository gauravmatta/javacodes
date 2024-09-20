package java8.streams;

import java.util.Arrays;
import java.util.List;

public class MapExample {

	public static void main(String[] args) {
		List<String> vehicles = Arrays.asList("bus","car","bicycle","flight","train");
		List<String> vehiclesListinUpperCase = vehicles.stream().map(v -> v.toUpperCase()).toList();
		System.out.println(vehiclesListinUpperCase);
		List<Integer> vehicleLength = vehicles.stream().map(v->v.length()).toList();
		System.out.println(vehicleLength);
		
	}

}
