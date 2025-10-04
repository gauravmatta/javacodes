package com.javaimplant.java17.interfaces;

public interface IFaceG {

    public static void main(String[] args){
        System.out.println("I am void main inside interface");
        testMe();
        C c = new C();
        c.testMeA();
//        IFaceG a=()->System.out.println("My Abstract Method");
    }

    private static void testMe(){
        System.out.println("Java Ahoi");
    }

    default void testMeA(){
        System.out.println("Default Method");
    }

    class C implements IFaceG{
    }
//    void testMeB();
}
