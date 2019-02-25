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
public class ThisReferenceExample {
    
    public static void main(String args[])
    {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        thisReferenceExample.doProcess(10, new Process(){
            @Override
            public void process(int i) {
                System.out.println(i);
                System.out.println(this);
            }

            @Override
            public String toString() {
                return "This is an anonymous inner class";
            }
            
            
        });
        
        thisReferenceExample.doProcess(10,i -> {
            System.out.println("Value of i from lambda is "+i);
//            System.out.println(this); //Lambda Expressions do not alter this reference so this is invalid
        });
        
        thisReferenceExample.execute();
    }

    @Override
    public String toString() {
        return "ThisReferenceExample{" + '}';
    }
    
    
    
    public void execute()
    {
        System.out.println(this);
        doProcess(10,i->{
            System.out.println("Value of i from lambda inside execute is "+i);
            System.out.println(this);
        });
    }
    
    public void doProcess(int i,Process p)
    {
        p.process(i);
    }
}
