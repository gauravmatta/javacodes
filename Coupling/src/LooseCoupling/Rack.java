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
public interface Rack {
    public int shelves=5;
    
    void getBooksByShelf(int shelf);
    void getBooksInRack();
    void addBooks(String book);
    void setShelf(int shelf);
}
