/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Gaurav Matta
 */
public class EmployeesRepository {
    public static void main(String args[])
    {
        List<Employee> employees=Arrays.asList(
                new Employee("Gaurav","Matta",31),
                new Employee("Vivek","Sharma",28),
                new Employee("Michel","Lee",27),
                new Employee("Steve","Warne",45),
                new Employee("Ricky","Gichrist",40),  
                new Employee("Greg","Right",35) 
        );
        
        //Sort Employees by Last Name
        Collections.sort(employees, new Comparator<Employee>(){
            @Override
            public int compare(Employee o1, Employee o2) {
               return o1.getLast_name().compareTo(o2.getLast_name());
            }   
        });
        
        Collections.sort(employees,(e1,e2)->e1.getFirst_name().compareTo(e2.getFirst_name()));
        
        
        //A method that prints all Employees in List
        System.out.println("Printing All Employees :");
        printall(employees);
        
        System.out.println();
        System.out.println("Printing All Employees using Lambda Expression :");
        printConditionally(employees,e->true);
        
        
        //A method with all the people which have first name beginning with "G"
        System.out.println();
        System.out.println("Printing All Employees First Name Beginning with G:");
        printFirstNameBeginningWithG(employees);
        
        
        
        //Print with Self Condition(First Name beginning with M)
        System.out.println();
        System.out.println("Printing Conditionally:");
        System.out.println("Printing first name with M:");
        printConditionally(employees,new Condition(){
            @Override
            public boolean test(Employee e) {
                return e.getFirst_name().startsWith("M");
            }    
        });
        
        System.out.println();
        System.out.println("Printing Conditionally using Lambda Expression:");
        System.out.println("Printing first name with M using Lambda:");
        printConditionally(employees,e->e.getFirst_name().startsWith("G"));
        System.out.println("Printing first name with M using Lambda:");
        printConditionally(employees,e->e.getFirst_name().startsWith("M"));
        
    }

    private static void printall(List<Employee> employees) {
        for(Employee e : employees)
        {
            System.out.println(e);
        }
    }

    private static void printFirstNameBeginningWithG(List<Employee> employees) {
        for(Employee e : employees)
        {
            if(e.getFirst_name().startsWith("G"))
            {    
                System.out.println(e);
            }
        }
    }

    private static void printConditionally(List<Employee> employees, Condition condition) {
        for(Employee e : employees)
        {
            if(condition.test(e))
            {    
                System.out.println(e);
            }
        }
    }
}
