/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Gaurav Matta
 */
public class HelloWorld {
    public static void main(String args[])
    {
        System.out.println("First Class Gets Loaded");
        try 
        {
            Thread.sleep(180000);
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
    }
}
