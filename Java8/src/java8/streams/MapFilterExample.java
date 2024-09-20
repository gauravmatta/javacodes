package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java8.entity.Employee;

public class MapFilterExample {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee(101,"Alex",10000),
				new Employee(102,"Brain",20000),
				new Employee(103,"Charles",30000),
				new Employee(104,"David",40000),
				new Employee(105,"Edward",50000)
				);
		List<Integer> salaries = employees.stream().filter(e->e.getSalary()>20000)
						.map(e->e.getSalary())
						.collect(Collectors.toList());
		System.out.println(salaries);
	}

}
