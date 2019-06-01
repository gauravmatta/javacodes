/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TightCoupling;

import java.util.ArrayList;

/**
 *
 * @author Gaurav Matta
 */
public class Book {
    public static void main(String args[])
    {
        Rack r1=new Rack();
        Rack r2=new Rack();
        int shelf=2;
        if(r1.books[shelf]==null)
        {
            r1.books[shelf]=new ArrayList();
        }
        r1.books[shelf].add("Introduction to Java");
        r1.books[shelf].add("Thumbs Up Java");
        shelf=1;
        if(r2.books[shelf]==null)
        {
            r2.books[shelf]=new ArrayList();
        }
        r2.books[shelf].add("Java Needs");
        r2.books[shelf].add("Java Stream");
        r1.getBooksInRack();
        r2.getBooksInRack();
    }
}
