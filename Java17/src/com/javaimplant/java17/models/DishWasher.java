package com.javaimplant.java17.models;

import com.javaimplant.java17.records.Dish;

import java.util.ArrayList;
import java.util.List;

public class DishWasher {
    private static List<Dish> ld=new ArrayList<>();
    public static List<Dish> retDList(){
        String[] arr1= {"Pasta","Manchurian","Biryani","Pizza","Burger"};
        boolean[] arr2= {true,false,false,true,true};
        int[] arr3= {12,32,90,75,88};
        for (int i = 0; i < arr3.length; i++) {
            var dish=new Dish(arr1[i],arr2[i],arr3[i]);
            ld.add(dish);
        }
        return ld;
    }
}
