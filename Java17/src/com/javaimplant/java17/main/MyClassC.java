package com.javaimplant.java17.main;

import java.util.Arrays;

public class MyClassC {
    private String cname;

    public MyClassC(String cname){
        this.cname=cname;
        System.out.println(this.cname);
    }

    interface MyClassCInterface {
        public MyClassC getMyClassC(String cname);
    }

    public static void main(String[] args) {
        interfaceReturnsObject();
        printUsingStreams();
    }

    private static void printUsingStreams() {
        String[] bb = {"Java", "JavaScript", "Python", "C++", "C#"};
        Arrays.asList(bb).stream().forEach(System.out::println);
    }

    private static void interfaceReturnsObject() {
        MyClassCInterface myClassCInterface = (s)-> new MyClassC(s);
        myClassCInterface.getMyClassC("Java Implant Blog is a great place to learn Java!");
    }
}
