package com.javaimplant.codingproblems.naggaro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeWithGreaterSalary {

	public static void main(String args[]) {
		Employee e1=new Employee("Gaurav","Sales",15000L);
		Employee e2=new Employee("Rajat","Sales",10000L);
		Employee e3=new Employee("Vinod","Sales",20000L);
		HashMap<String, Employee> employeeMap = new HashMap<  String, Employee>();
		employeeMap.put("gaurav", e1);
		employeeMap.put("rajat", e2);
		employeeMap.put("vindod", e3);
		long targetSalary = 10000;
		employeeMap.values().stream()
         .filter(e -> e.getSalary() > targetSalary)
         .forEach(System.out::println);
		List<Employee> employee = employeeMap.values().stream()
				.filter(e -> e.getSalary() > targetSalary)
				.toList();
		System.out.println(employee);
		employeeMap.entrySet()
		   .stream()
		   .map(e -> {
			   System.out.println(e.getKey()+"==>"+e.getValue());
			   return e.getKey()+" "+e.getValue();
		   }).collect(Collectors.toList());
	}
	
}

class Employee {
	String name;
	String dept;
	long salary;
	
	Employee(String name,String dept,long salary){
		this.name=name;
		this.dept=dept;
		this.salary=salary;
	}

	public long getSalary() {
		return this.salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
	
}