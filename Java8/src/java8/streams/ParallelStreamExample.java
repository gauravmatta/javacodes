package java8.streams;

import java.util.Arrays;
import java.util.List;

import java8.entity.Student;

public class ParallelStreamExample {

	public static void main(String[] args) {
		
		List<Student> studentList = Arrays.asList(
				new Student(82,"Lamborgini","Lampard", 12000),
				new Student(90,"Audi","Markus", 13000),
				new Student(65,"BMW","Luci", 15000),
				new Student(55,"Chevrolet","Luca", 18000),
				new Student(85,"Maruti","Leese", 11000),
				new Student(88,"Ford","Ola", 17000),
				new Student(50,"Hyundyi","Peter", 15000)
				);
		
		studentList.stream().filter(s->s.getGrade()>80).limit(3).forEach(
				stu->{
					System.out.println(stu.getName()+" "+stu.getGrade()); 
				});
		System.out.println("Using Parallel Stream ====>");
		studentList.parallelStream().filter(s->s.getGrade()>80).limit(3).forEach(
				stu->{
					System.out.println(stu.getName()+" "+stu.getGrade()); 
				});
		System.out.println("Using Parallel Method ====>");
		studentList.stream().parallel().filter(s->s.getGrade()>80).limit(3).forEach(
				stu->{
					System.out.println(stu.getName()+" "+stu.getGrade()); 
				});
	}

}
