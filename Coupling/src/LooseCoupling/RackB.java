/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LooseCoupling;

import java.util.ArrayList;

/**
 *
 * @author Gaurav Matta
 */
public class RackB implements Rack {
    
    private int shelf;
    private final ArrayList<String> books[]=new ArrayList[shelves];

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }
    
    @Override
    public void addBooks(String book) {
        if(this.books[shelf]==null)
        {
            this.books[shelf]=new ArrayList();
        }
        this.books[shelf].add(book);
    }

    @Override
    public void getBooksByShelf(int shelf)
    {
         System.out.println(this.books[shelf]);
    }

    @Override
    public void getBooksInRack() 
    {
        for(ArrayList s:books)
        {
            System.out.println(s);
        }
    }
    
}
