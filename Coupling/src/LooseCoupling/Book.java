/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LooseCoupling;

/**
 *
 * @author Gaurav Matta
 */
public class Book {
    
    public static void main(String[] args)
    {
        System.out.println("In Main");
        Rack r1=new RackA();
        Rack r2=new RackB();
        r1.setShelf(1);
        r1.addBooks("Introduction to Java");
        r1.addBooks("Android Basics");
        r1.setShelf(2);
        r1.addBooks("Introduction to J2EE");
        r1.addBooks("Advanced Java Concepts");
        System.out.println("Books in Shelf 1");
        r1.getBooksByShelf(1);
        System.out.println("Books in Rack");
        r1.getBooksInRack();
        
        r2.setShelf(1);
        r2.addBooks("Introduction to Java");
        r2.addBooks("Android Basics");
        r2.setShelf(2);
        r2.addBooks("Introduction to J2EE");
        r2.addBooks("Advanced Java Concepts");
        System.out.println("Books in Shelf 1");
        r2.getBooksByShelf(1);
        System.out.println("Books in Rack");
        r2.getBooksInRack();
    }
    
}
