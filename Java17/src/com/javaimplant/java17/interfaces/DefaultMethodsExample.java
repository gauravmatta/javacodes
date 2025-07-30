package com.javaimplant.java17.interfaces;

public interface DefaultMethodsExample {
    default void metha(){
        System.out.println("This is default method");
    }

    default void metha(int a){
        System.out.println("Overloaded Method with param "+a);
    }

}

