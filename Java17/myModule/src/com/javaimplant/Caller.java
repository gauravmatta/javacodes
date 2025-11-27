package com.javaimplant;

import com.javaimplant.module.a.ClassRoot;

public class Caller {
    public static void main(String[] args) {
        System.out.println("Caller main: Hello from Caller in myModule");
        ClassRoot root = new com.javaimplant.module.a.ClassRoot();
        root.prnRoot(10);
        //Below class cannot be imported directly as module c does not export its packages to myModule
//        com.javaimplant.module.c.UClass.main(new String[]{"arg1", "arg2"});
//        try (com.javaimplant.java17.features.MyResource resource = new com.javaimplant.java17.features.MyResource()) {
//            resource.doSomething();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
