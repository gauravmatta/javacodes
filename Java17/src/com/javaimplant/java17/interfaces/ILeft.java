package com.javaimplant.java17.interfaces;

public interface ILeft {
    default void m1(){
        System.out.println("Coming from Left Interface");
    }

    default void m2(){
        System.out.println("Second Method");
    }
}
