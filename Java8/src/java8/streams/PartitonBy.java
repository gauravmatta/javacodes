package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitonBy {

	public static void main(String[] args) {
		
		Student s1 = new Student(8, "fiat","Dave");
		Student s2 = new Student(15, "fiat","MadMax");
		Student s3 = new Student(14, "ferrari","Paul");
		
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		Map<Boolean, List<Student>> partitionResult = students.stream().collect(
				Collectors.partitioningBy(student -> student.getGrade()>10));
		
		partitionResult.forEach((k,v)->System.out.println("key is "+k+"\n values \n"+ v));
		
		Map<Object, List<Student>> groupingResult = students.stream().collect(
				Collectors.groupingBy(Student::getCar));
		
				groupingResult.forEach((k,v)->System.out.println("key is "+k+"\n values \n"+ v));
	}

}
