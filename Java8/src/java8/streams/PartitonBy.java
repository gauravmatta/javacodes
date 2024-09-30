package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java8.entity.Student;

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
		 
		 List<String> numbers = Arrays.asList("one","two","three","four","five","six","seven","eight","nine","ten","twenty");
		 Map<Boolean, List<String>> collect = numbers.stream()
			.collect(Collectors.partitioningBy(s->s.length()>3));
		 System.out.println(collect);
		 Map<Boolean, Long> collectCount = numbers.stream()
					.collect(Collectors.partitioningBy(s->s.length()>3,Collectors.counting()));
		 System.out.println(collectCount);
		 
		 Map<Integer, List<String>> groupLength = numbers.stream().collect(Collectors.groupingBy(s->s.length()));
		 System.out.println(groupLength);
		 
		 Map<Integer, String> groupJoin = numbers.stream().collect(Collectors.groupingBy(s->s.length(),Collectors.joining("=>")));
		 System.out.println(groupJoin);
		 
		 Map<Integer, List<String>> collecttoUpperCase = numbers.stream().collect(Collectors.groupingBy(s->s.length(),Collectors.mapping(s->s.toUpperCase(),Collectors.toList())));
		 System.out.println(collecttoUpperCase);
	}
}
