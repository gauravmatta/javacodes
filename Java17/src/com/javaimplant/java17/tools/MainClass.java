package com.javaimplant.java17.tools;

public class MainClass {
    static void main() {
        ClassB objB = new ClassB();
        objB.getData().forEach(System.out::println);
    }
}
