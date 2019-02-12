/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.lambda;

/**
 *
 * @author 703199444
 */
public class RunnableExample {
    public static void main(String args[])
    {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running from Interface Implementation");
            }
        });
        
        Thread lambdaThread=new Thread(()->System.out.println("Running from Lambda Thread"));
        
        myThread.run();
        lambdaThread.run();
    }
}
