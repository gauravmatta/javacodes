package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitonBy {

	public static void main(String[] args) {

		Student s1 = new Student(8, "fiat", "Dave",12000);
		Student s2 = new Student(15, "fiat", "MadMax",15000);
		Student s3 = new Student(14, "ferrari", "Paul",4000);

		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		Map<Boolean, List<Student>> partitionResult = students.stream()
				.collect(Collectors.partitioningBy(student -> student.getGrade() > 10));

		partitionResult.forEach((k, v) -> System.out.println("key is " + k + "\n values \n" + v));

		Map<Object, List<Student>> groupingResult = students.stream().collect(Collectors.groupingBy(Student::getCar));

		groupingResult.forEach((k, v) -> System.out.println("key is " + k + "\n values \n" + v));

		List<Integer> integers = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5, 3, 6, 6, 3);

		Map<Integer, List<Integer>> response = integers.stream().collect(Collectors.groupingBy(Integer::intValue));

		response.forEach((k, v) -> System.out.println("key is " + k + "\n values \n" + v));
		response.forEach((k, v) -> System.out.println("Frequency for " + k + "=>" + response.get(k).size()));
		
		 HashMap<Integer, Integer> frequencyMap = new HashMap<>();
		 for (int num : integers) {
	            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
	        }
		 System.out.println(frequencyMap);
	}

}
