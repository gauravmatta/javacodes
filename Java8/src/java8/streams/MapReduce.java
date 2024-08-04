package java8.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapReduce {
public static void main(String[] args) {
	
	List<Integer> numbers = Arrays.asList(3,7,8,1,5,9);
	int sum=0;
	for(int no:numbers) {
		sum=sum+no;
	}
	System.out.println(sum);
	int sum2 = numbers.stream().mapToInt(i->i).sum();
	System.out.println(sum2);
	
	Integer reduceSum = numbers.stream().reduce(0,(a,b)->a+b);
	System.out.println(reduceSum);
	
	Optional<Integer> reduceIntSum = numbers.stream().reduce(Integer::sum);
	System.out.println(reduceIntSum.get());
	
	Integer reduceMultiply = numbers.stream().reduce(1,(a,b)->a*b);
	System.out.println(reduceMultiply);
	
	Integer reduceMax = numbers.stream().reduce(0,(a,b)->a>b?a:b);
	System.out.println(reduceMax);
	
	Integer reduceMaxMethodReference = numbers.stream().reduce(Integer::max).get();
	System.out.println(reduceMaxMethodReference);
	
	List<String> words = Arrays.asList("Core","Java","Spring","Hibernate","Postgres");
	String maxLengthWord = words.stream().reduce((word1,word2)->word1.length()>word2.length()?word1:word2).get();
	System.out.println(maxLengthWord);
	
	double avgStipend = getStudents().stream()
	.filter(student -> student.getGrade()>10)
	.map(Student::getStipend)
	.mapToDouble(i->i)
	.average().getAsDouble();
	System.out.println(avgStipend);
	
	double sumStipend = getStudents().stream()
	.filter(student -> student.getGrade()>10)
	.map(Student::getStipend)
	.mapToDouble(i->i)
	.sum();
	
	System.out.println(sumStipend);
	
	
	
}
public static List<Student> getStudents()
{
	return Stream.of(
		new Student(8, "fiat", "Dave",12000),
		new Student(15, "fiat", "MadMax",15000),
		new Student(14, "ferrari", "Paul",4000)
			).collect(Collectors.toList());
}
}
