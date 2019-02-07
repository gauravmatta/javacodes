/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaurav Matta
 */
public class Prog {
    
    Prog(int a,int b)
    {
        System.out.println("Int Int :");
        System.out.println("a="+a+"b="+b);
    }
    
    Prog(int a,float b)
    {
        System.out.println("Int Float :");
        System.out.println("a="+a+"b="+b);
    }
    
    Prog()
    {
        
    }
    
    public void function1()
    {
        System.out.println(10+20+"java implant");
        System.out.println("java implant"+10+20);
    }
    
    public void function2()
    {
        System.out.println(10*20+"java implant");
        System.out.println("java implant"+10*20);
    }
    
    public static void main(String args[]) 
    {
        Prog p=new Prog();
        p.function1();
        p.function2();
        byte a=10;
        byte b=15;
        Prog p1=new Prog(a,b);
    }
}
