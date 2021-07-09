/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.lambda;

import java.util.function.BiConsumer;

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
        Greeting hello =new Hello();
        Greeting finish=new Finish();
        Greeting greetingFunction = () -> System.out.println("Hello from Lambda");
        Greeting innerClass = new Greeting(){
            @Override
            public void perform() {
                System.out.println("Hello from Inner Class");
            }
        };
        basics.greet(hello);
        basics.greet(greetingFunction);
        basics.greet(innerClass);
        BiConsumer<Integer,Integer> biConsumer = (a,b) -> System.out.println(a+b);
        biConsumer.accept(5, 10);
    }
    
    public void add(int a,int b) {
    	System.out.println(a+b);
    }
}
