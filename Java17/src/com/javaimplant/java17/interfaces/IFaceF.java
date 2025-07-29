package com.javaimplant.java17.interfaces;

@FunctionalInterface
public interface IFaceF extends IFaceE {
    public void method(String a,String b);
    default void method1(){
        System.out.println("One");
    }
    default void method2(){
        System.out.println("Two");
    }
}
