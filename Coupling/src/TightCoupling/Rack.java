/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TightCoupling;

import static LooseCoupling.Rack.shelves;
import java.util.ArrayList;

/**
 *
 * @author Gaurav Matta
 */
public class Rack 
{
    public int shelf;
    public final ArrayList<String> books[]=new ArrayList[shelves];

    public void getBooksByShelf(int shelf)
    {
         System.out.println(this.books[shelf]);
    }

    public void getBooksInRack() 
    {
        for(ArrayList s:books)
        {
            System.out.println(s);
        }
    }
}
