package com.javaimplant.java17.utils;

import com.javaimplant.java17.models.Books;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BookUtils {
    private List<Books> liBooks = new ArrayList<Books>();

    /**
     * Utility Function to generate test data for books
     * @return {@link List<Books>}
     * @author Gaurav Matta
     */
    public List<Books> retBooks(){
        Integer[] arr1= {1,2,3,4,5};
        String[] arr2={"Ramayana","Mahabharat","Ainaneakbari","Elephant Song","Who shall tell the president"};
        String[] arr3={"Valmiki","Vyas","Akbar","Wilbur Smith","J Archer"};
        for(int i=0;i<arr3.length;i++){
            Books b=new Books(arr1[i],arr2[i],arr3[i]);
            liBooks.add(b);
        }
        return liBooks;
    }

    public void drawLine() {
        System.out.println("*".repeat(50));
    }

    public void prnStatus(Predicate<Books> pre, Books b){
        if(pre.test(b)){
            System.out.println("The books satisfying your condition is "+b);
        }
    }
    public void prnStatus(Predicate<Integer> pre, Integer i){
        if(pre.test(i)){
            System.out.println("The number satisfying your condition is "+i);
        } else {
            System.out.println("The number does not satisfy your condition: " + i);
        }
    }
}
