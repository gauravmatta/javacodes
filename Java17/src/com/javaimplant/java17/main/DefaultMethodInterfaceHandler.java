package com.javaimplant.java17.main;

import com.javaimplant.java17.interfaces.DefaultMethodsExample;

public class DefaultMethodInterfaceHandler {
    public static void main(String[] args) {
        DefaultMethodsExample example = new DefaultMethodsExample() {
            @Override
            public void metha() {
                System.out.println("I am overriden");
            }

            @Override
            public void metha(int a) {
                System.out.println("Overloaded and Overridden at the same time");
            }
        };
        example.metha();
        example.metha(10);
    }
}
