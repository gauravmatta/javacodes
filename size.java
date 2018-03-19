/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaurav Matta
 */
public class size {
    
    public static void main(String args[])
    {
        System.out.println("Size of byte: "+(Byte.SIZE/8)+" bytes.");
        System.out.println("Size of Short: "+(Short.SIZE/8)+" bytes.");
        System.out.println("Size of int: " + (Integer.SIZE/8) + " bytes.");
        System.out.println("Size of long: " + (Long.SIZE/8) + " bytes.");
        
        System.out.println("Size of byte: "+(Byte.BYTES)+" bytes.");
        System.out.println("Size of Short: "+(Short.BYTES)+" bytes.");
        System.out.println("Size of int: " + (Integer.BYTES) + " bytes.");
        System.out.println("Size of long: " + (Long.BYTES) + " bytes.");
        
        System.out.println("Minimum size of byte: "+Byte.MIN_VALUE);
        System.out.println("Maximum size of byte: "+Byte.MAX_VALUE);
        System.out.println("Minimum size of Short: "+Short.MIN_VALUE);
        System.out.println("Maximum size of Short: "+Short.MAX_VALUE);
        System.out.println("Minimum size of Integer: "+Integer.MIN_VALUE);
        System.out.println("Maximum size of Integer: "+Integer.MAX_VALUE);
        System.out.println("Minimum size of Long: "+Long.MIN_VALUE);
        System.out.println("Maximum size of Long: "+Long.MAX_VALUE);
    }
    
}
