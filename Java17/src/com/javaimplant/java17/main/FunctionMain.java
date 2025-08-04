package com.javaimplant.java17.main;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionMain {

    interface IFunctionA{
        String sayHello(String a);
    }

    public static void main(String[] args) {
        methodOne();
        methodTwo();
        biFunctionCall();
        arrayFlattener();
        implementFunctionWithStringIntgerTypes();
    }

    private static void implementFunctionWithStringIntgerTypes() {
        Function<String, Integer> func = String::length;
        System.out.println(func.apply("This is a String whose length will be printed"));
        Function<Integer,String> drawline = "*"::repeat;
        System.out.println(drawline.apply(50));
    }

    private static void arrayFlattener() {
        Function<String[],String> funb = Arrays::toString;
        String[] arr = {"Newton","Einstein","Raman","Linus","Bhaskaracharya"};
        System.out.println(funb.apply(arr));
    }

    private static void biFunctionCall() {
        BiFunction<String,String,String> bif = (a,b)->{
          return a.toUpperCase()+" "+b.toUpperCase();
        };
        System.out.println(bif.apply("Gaurav","Matta"));
    }

    private static void methodTwo() {
        Function<String,String> funa=(a) ->"Hello There "+a;
        String pp = funa.apply("Gaurav");
        System.out.println(pp);
    }

    private static void methodOne() {
        IFunctionA fa = (a)->"Hello there "+ a;
        System.out.println(fa.sayHello("Gaurav"));
    }
}
