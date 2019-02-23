/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
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
        
        //Exceptions in Lambda Functions
        System.out.println("==============Using Exceptions============");
        int[] arrayNumbers={1,2,3,4,5,6,7,8,9,10};
        int key=2;
        
        System.out.println("Division using Using BiConsumer");
        operateNoReturn(arrayNumbers,key,(a1,a2)->{
            System.out.print(a1+"=>");
            System.out.println(a1/a2);
        });
        
        //Calling Exceptions during function implementation 
        System.out.println("Division using Using BiFunction");
        for(int a : arrayNumbers)
        {
            System.out.print(a+"=>");
            int i = operateReturnInt(a,key,(a1,a2)->{
                            try
                            {
                                return (a1/a2);
                            }
                            catch(ArithmeticException e)
                            {
                                System.out.println("Arithmetic Exception cought in Main Method");
                                return 0;
                            }
                        });
            System.out.println(i);
        }
        
        //Calling Exceptions in a Wrapper Function
        System.out.println("Calling Exceptions in a Wrapper Function");
        for(int a : arrayNumbers)
        {
            System.out.print(a+"=>");
            int i = operateReturnInt(a, key, wrapperLambda((a1,a2)->(a1/a2)));
            System.out.println(i);
        }
        
        //Exceptions in Lambda Functions
        
    }
    
    private static BiFunction<Integer,Integer,Integer> wrapperLambda(BiFunction<Integer,Integer,Integer> function)
    {
//        return function;
//        return (a1,a2)->(a1+a2);
        System.out.println("Inside Wrapper Lambda");
        try
        {
            return (a1,a2)->function.apply(a1,a2);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Exception caught in Wrapper Lambda Function");
        }
        return null;
    }
    
    private static void operateNoReturn(int[] array,int key,BiConsumer<Integer,Integer> consumer)
    {
        for(int a:array)
        {
            try
            {
                consumer.accept(a,key);
            }
            catch(ArithmeticException e)
            {
                System.out.println("Arithmetic Exception cought in Class Method");
            }
                    
        }
    }
    
    private static Integer operateReturnInt(int number,int key,BiFunction<Integer,Integer,Integer> function)
    {
        return function.apply(number, key);
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
