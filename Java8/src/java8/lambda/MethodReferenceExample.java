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

/**
 *
 * @author Gaurav Matta
 */
public class MethodReferenceExample {
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
        printConditionally(employees,e->true,e->System.out.println(e));
        printConditionally(employees,e->true,System.out::println);
        printMessage();
        Thread t1= new Thread(()->printMessage());
        Thread t2= new Thread(MethodReferenceExample::printMessage);
        t1.start();
        t2.start();
    }
    
    private static void printConditionally(List<Employee> employees, Predicate<Employee> condition,Consumer<Employee> consumer) {
        for(Employee e : employees)
        {
            if(condition.test(e))
            {    
                consumer.accept(e);
            }
        }
    }
    
    public static void printMessage()
    {
        System.out.println("Hello");
    }
}
