package com.javaimplant.java17.interfaces;

public interface IFaceG extends IFaceE{
    public void retY();
    public void retZ();

    public static void main(String[] args){
        System.out.println("I am void main inside interface");
        testMe();
        C c = new C();
        c.testMeA();
    }

    private static void testMe(){
        System.out.println("Java Ahoi");
    }

    default void testMeA(){
        System.out.println("Default Method");
    }

    class C implements IFaceG{

        @Override
        public void retY() {

        }

        @Override
        public void retZ() {

        }

        @Override
        public void method(String a, String b) {

        }
    }
}
