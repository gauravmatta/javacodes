/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaurav Matta
 */
public class Test1 
{
    int test_a,test_b;
    Test1(int a,int b)
    {
        test_a=a;
        test_b=b;
    }
    
    Test1()
    {
        
    }
    
    public static void main(String args[])
    {
        Test1 test=new Test1();
        System.out.println(test.test_a+" "+test.test_b);
    }
}
