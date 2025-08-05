package com.javaimplant.java17.main;

public class ConstructorMain {
    private String s;
    public ConstructorMain(String s) {
        this.s = s;
        System.out.println("Constructor called with value: " + s);
    }
    public ConstructorMain() {
        this("Default Value");
        System.out.println("No-arg constructor called.");
    }

    interface IntrF{
        public ConstructorMain get(String s);
    }

    public static void main(String[] args) {
        usingLambda();
        usingMethodReference();
    }

    private static void usingMethodReference() {
        IntrF ffb = ConstructorMain::new;
        ffb.get("Gaurav");
    }

    private static void usingLambda() {
        IntrF ffa= (s)-> new ConstructorMain(s);
        ffa.get("Gaurav");
    }
}
