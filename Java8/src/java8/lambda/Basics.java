/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.lambda;

/**
 *
 * @author Gaurav Matta
 */
public class Basics {
    public void greet(Greeting greet)
    {
        greet.perform();
    }
    
    public static void main(String[] args)
    {
        Basics basics=new Basics();
        Hello hello =new Hello();
        Finish finish=new Finish();
        basics.greet(hello);
        System.out.println("We just saw how we can greet a person using Java Behaviours.");
        basics.greet(finish);
    }
}
