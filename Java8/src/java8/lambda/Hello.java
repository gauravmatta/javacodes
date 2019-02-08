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
public class Hello implements Greeting{

    @Override
    public void perform() {
        System.out.println("Hello Everyone");
    }
    
}
