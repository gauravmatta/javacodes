package com.javaimplant.java17.main;

import java.util.function.Predicate;

public class PredicateMain {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,55,77,88,99,10};
        usingBoolean(arr);
        drawLine();
        usingPredicate(arr);
        drawLine();
        usingComplexPredicate(arr);
        drawLine();
        passPredicateToMethod(arr);
    }

    private static void passPredicateToMethod(Integer[] arr) {
        Predicate<Integer> predc=(a)->a%2==0;
        for(Integer i: arr){
            testForMyValue(predc,i);
        }
    }

    private static void usingComplexPredicate(Integer[] arr) {
        Predicate<Integer> predb=(a)->(a>10&&a<70);
        for(Integer i: arr){
            if(predb.test(i)){
                System.out.printf("It's true the value is %d\n",i);
            }
        }
    }

    private static void testForMyValue(Predicate<Integer> p,Integer i) {
        System.out.println(p.test(i)+" the value is "+ i);
    }

    private static void drawLine() {
        System.out.println("*".repeat(50));
    }

    private static void usingPredicate(Integer[] arr) {
        Predicate<Integer> preda = (a)->a>10;
        for(Integer i: arr){
            if(preda.test(i)){
                System.out.println("It's true");
            }
        }
        System.out.println(preda.test(100));
    }

    private static void usingBoolean(Integer[] arr) {
        for(Integer i: arr){
            if(test(i)){
                System.out.println("It's true");
            }
        }
    }

    private static boolean test(Integer t) {
        if(t>10){
            return true;
        } else {
            return false;
        }
    }
}
