/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Gaurav Matta
 */
public class FunctionalRepository {
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
        
        System.out.println("Printing All Employees:");
        printConditionally(employees,e->true);
        
        System.out.println("Printing first name with G using Lambda:");
        printConditionally(employees,e->e.getFirst_name().startsWith("G"));
        System.out.println("Printing first name with M using Lambda:");
        printConditionally(employees,e->e.getFirst_name().startsWith("M"));
        System.out.println("Printing first name with S using Lambda:");
        performConditionally(employees,e->e.getFirst_name().startsWith("S"),e->System.out.println(e));
        System.out.println("Printing first name using Lambda:");
        performConditionally(employees,e->true,e->System.out.println(e.getFirst_name()));
        System.out.println("Printing all have first name with S using Streams:");
        List<Employee> el = employees.stream().filter(e-> e.getFirst_name().startsWith("S")).collect(Collectors.toList());
        printConditionally(el,e->true);    
        
        
    }
    
    private static void performConditionally(List<Employee> employees,Predicate<Employee> condition,Consumer<Employee> consumer)
    {
        for (Employee e: employees)
        {
            if(condition.test(e))
            {
                consumer.accept(e);
            }
        }
    }
    private static void printConditionally(List<Employee> employees, Predicate<Employee> condition) {
        for(Employee e : employees)
        {
            if(condition.test(e))
            {    
                System.out.println(e);
            }
        }
    }
}
