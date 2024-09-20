package java8.streams;

import java.util.Arrays;
import java.util.List;

public class MapExample {

	public static void main(String[] args) {
		List<String> vehicles = Arrays.asList("bus","car","bicycle","aeroplane","train","truck","scooter");
		List<String> vehiclesListinUpperCase = vehicles.stream().map(v -> v.toUpperCase()).toList();
		System.out.println(vehiclesListinUpperCase);
		List<Integer> vehicleLength = vehicles.stream().map(v->v.length()).toList();
		System.out.println(vehicleLength);
		vehicles.stream().map(v->v.length()).forEach(System.out::println);
		List<Integer> multiplyByThree = vehicleLength.stream().map(n->n*3).toList();
		System.out.println(multiplyByThree);
		vehicleLength.stream().map(n->n*3).forEach(System.out::println);
	}

}
