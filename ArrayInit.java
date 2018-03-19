
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaurav Matta
 */
public class ArrayInit {
    
    public void arrayRef()
    {
        int []arr1={1,2,3,4,5,6};
        int []arr2=arr1;
        Arrays.fill(arr1,9);
        for(int i=0;i<arr2.length;i++)
        {
            System.out.println(arr2[i]);
        }
    }
    
    public static void main(String args[])
    {
        //Both arrays refer to same array
        ArrayInit a1=new ArrayInit();
        a1.arrayRef();
    }
}
