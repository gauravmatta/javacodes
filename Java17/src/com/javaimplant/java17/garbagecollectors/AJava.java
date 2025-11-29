package com.javaimplant.java17.garbagecollectors;

public class AJava {
    public static void main(String[] args) {
        System.out.println("Hello, Java 17 Garbage Collectors!");
        for(int i=0;i<100000;i++) {
            String temp = "String number " + i;
            System.out.println(temp);
        }
    }
}
