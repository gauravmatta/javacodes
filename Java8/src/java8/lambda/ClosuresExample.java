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
public class ClosuresExample {
    public static void main(String args[])
    {
        int a=10;
        int b=20;
        doProcess(a, new Process(){
            @Override
            public void process(int i) {
                System.out.println(i+b);
            }
        });
        
        doProcess(a,i->System.out.println(i+b));
    }
    
    public static void doProcess(int i,Process p)
    {
        p.process(i);
    }
}
