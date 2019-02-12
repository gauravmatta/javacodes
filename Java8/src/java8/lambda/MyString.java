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
public class MyString {
    public static void main(String args[])
    {
        StringLength myString= s->s.length();
        System.out.println(myString.getlength("Lambda"));
        getLength(s->s.length());
    }
    
    static void getLength(StringLength s)
    {
        System.out.println(s.getlength("My Lambda"));
    }
}
