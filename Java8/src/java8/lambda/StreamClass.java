/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author 703199444
 */
public class StreamClass {
    
    public static void main(String args[])
    {
        List<Employee> employees=Arrays.asList(
                new Employee("Gaurav","Matta",31),
                new Employee("Vivek","Sharma",28),
                new Employee("Michel","Lee",27),
                new Employee("Steve","Warne",45),
                new Employee("Ricky","Gichrist",40),  
                new Employee("Greg","Right",35),
                new Employee("Sachin","Kumble",32)
        );
        
        System.out.println("Using For Loop");
        for(int i=0;i<employees.size();i++)
        {
            System.out.println(employees.get(i));
        }
        
        System.out.println("Using For In/FOr Each Loop");
        for(Employee e:employees)
        {
            System.out.println(e);
        }
        
        System.out.println("Using Lambda For Each Loop");
        employees.forEach(p->System.out.println(p));
        
        System.out.println("Using Lambda For Each Loop using Method Reference");
        employees.forEach(System.out::println);
        
        employees.stream()
                .filter(e->{
                    System.out.print(e.getLast_name()+" ");
                    return e.getFirst_name().startsWith("G");
                        })
                .forEach(e->System.out.println(e.getFirst_name()));
        
        Stream<Employee> emp=employees.stream().filter(e->e.getFirst_name().startsWith("G"));
        long empCount=employees.stream().filter(e->e.getFirst_name().startsWith("G")).count();
        System.out.println(empCount);
        
        //Parallel Processing
        empCount=employees.parallelStream().filter(e->e.getFirst_name().startsWith("G")).count();
        System.out.println("By Parallel Stream "+empCount);
    }
}