package com.javaimplant.java17.main;

import com.javaimplant.java17.interfaces.InteMyClassB;

public class ConstructorMain {
    public ConstructorMain(String s) {
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
        usingLambdaTwoParams();
        usingMethodReferenceTwoParams();
    }

    private static void usingMethodReferenceTwoParams() {
        InteMyClassB clsb = MyClassB::new;
        clsb.getClassB("Gaurav", "Java Implant");
    }

    private static void usingLambdaTwoParams() {
        InteMyClassB clsb=(s,t)-> new MyClassB(s,t);
        clsb.getClassB("Gaurav", "Java Implant");
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
